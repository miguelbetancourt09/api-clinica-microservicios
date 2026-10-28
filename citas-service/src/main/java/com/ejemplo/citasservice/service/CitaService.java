package com.ejemplo.citasservice.service;
 import com.ejemplo.citasservice.entity.Cita; import com.ejemplo.citasservice.repository.CitaRepository;
 import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus;
 import org.springframework.web.server.ResponseStatusException; import java.util.List;
 @Service public class CitaService {
 private final CitaRepository repo;
 private final org.springframework.web.client.RestClient restClient = org.springframework.web.client.RestClient.create();
 @org.springframework.beans.factory.annotation.Value("${REFERENCE_URL:}") private String targetUrl;
 public CitaService(CitaRepository repo) {this.repo=repo;}
 public List<Cita> listar() {return repo.findAll();}
 public Cita obtener(Long id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 public Cita crear(Cita item) {item.setId(null); validarReferencia(item); return repo.save(item);}
 public Cita actualizar(Long id, Cita item) {obtener(id); validarReferencia(item); item.setId(id); return repo.save(item);}
 public void eliminar(Long id) {obtener(id); repo.deleteById(id);}
 private void validarReferencia(Cita item) { if (item.getPacienteId() == null) throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, "Referencia requerida: pacienteId");
    try { restClient.get().uri(targetUrl + "/" + item.getPacienteId()).retrieve().toBodilessEntity(); }
    catch (org.springframework.web.client.HttpClientErrorException.NotFound ex) { throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, "Referencia no existe: pacienteId"); }
    catch (org.springframework.web.client.RestClientException ex) { throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE, "Servicio de referencia no disponible"); } }
 }