package com.ejemplo.pacientesservice.service;
 import com.ejemplo.pacientesservice.entity.Paciente; import com.ejemplo.pacientesservice.repository.PacienteRepository;
 import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus;
 import org.springframework.web.server.ResponseStatusException; import java.util.List;
 @Service public class PacienteService {
 private final PacienteRepository repo;

 public PacienteService(PacienteRepository repo) {this.repo=repo;}
 public List<Paciente> listar() {return repo.findAll();}
 public Paciente obtener(Long id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 public Paciente crear(Paciente item) {item.setId(null); validarReferencia(item); return repo.save(item);}
 public Paciente actualizar(Long id, Paciente item) {obtener(id); validarReferencia(item); item.setId(id); return repo.save(item);}
 public void eliminar(Long id) {obtener(id); repo.deleteById(id);}
 private void validarReferencia(Paciente item) { }
 }