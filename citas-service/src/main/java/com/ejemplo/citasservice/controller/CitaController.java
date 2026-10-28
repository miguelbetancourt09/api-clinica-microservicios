package com.ejemplo.citasservice.controller;
 import com.ejemplo.citasservice.entity.Cita; import com.ejemplo.citasservice.service.CitaService;
 import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus;
 import jakarta.validation.Valid; import java.util.List;
 @RestController @RequestMapping("/api/citas") public class CitaController {
 private final CitaService service;
 public CitaController(CitaService service) {this.service=service;}
 @GetMapping public List<Cita> listar() {return service.listar();}
 @GetMapping("/{id}") public Cita obtener(@PathVariable Long id) {return service.obtener(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Cita crear(@Valid @RequestBody Cita item) {return service.crear(item);}
 @PutMapping("/{id}") public Cita actualizar(@PathVariable Long id,@Valid @RequestBody Cita item) {return service.actualizar(id,item);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) {service.eliminar(id);}
 }