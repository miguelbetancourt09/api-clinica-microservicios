# 02_api_clinica — API de microservicios Dockerizados

Incluye **dos aplicaciones Spring Boot independientes** y **dos bases de datos MySQL separadas**, una por microservicio. El segundo microservicio valida mediante una llamada HTTP que el ID del primero exista (no comparte base de datos).

## Requisitos

- Docker Desktop en ejecución (Docker Compose v2).
- Para ejecutar sin Docker: Java 17, Maven y MySQL con bases y usuarios configurados.

## Iniciar

Desde esta carpeta:

```bash
docker compose up --build -d
docker compose ps
docker compose logs -f
```

Arranque inicial: espera a que MySQL y las aplicaciones terminen de iniciar antes de hacer solicitudes.

## Endpoints

| Microservicio | URL | Métodos |
|---|---|---|
| pacientes-service | http://localhost:8091/api/pacientes | GET, GET /{id}, POST, PUT /{id}, DELETE /{id} |
| citas-service | http://localhost:8092/api/citas | GET, GET /{id}, POST, PUT /{id}, DELETE /{id} |

### Ejemplo 1: crear entidad principal

`POST http://localhost:8091/api/pacientes` con JSON:

```json
{
  "nombre": "Ana Perez",
  "correo": "ana@example.com",
  "telefono": "Ejemplo"
}
```

### Ejemplo 2: crear entidad dependiente

Después de crear la anterior y verificar su ID, `POST http://localhost:8092/api/citas`:

```json
{
  "pacienteId": 1,
  "fecha": "2026-11-12",
  "motivo": "Revision general"
}
```

Si el ID referenciado no existe, el servicio dependiente devuelve `400`; si el servicio principal no está accesible, devuelve `503`.

## Comprobación

```bash
curl http://localhost:8091/api/pacientes
curl http://localhost:8092/api/citas
```

## Detener

```bash
docker compose down
```

Para borrar también los datos de MySQL: `docker compose down -v` (**elimina los registros guardados**).

## Arquitectura

Cada microservicio tiene Controller, Service, Repository, Entity, su propio `pom.xml`, `Dockerfile` y su conexión propia a MySQL. Las contraseñas del Compose son **solo para desarrollo local**. Antes de producción, reemplázalas por secretos y añade seguridad, migraciones y observabilidad.
