package com.ejemplo.pacientesservice.entity;
 import jakarta.persistence.*;
 @Entity @Table(name="pacientes") public class Paciente {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
     @jakarta.validation.constraints.NotBlank private String nombre;
    @jakarta.validation.constraints.NotBlank private String correo;
    @jakarta.validation.constraints.NotBlank private String telefono;
 public Long getId() {return id;} public void setId(Long id) {this.id=id;}
     public String getNombre() { return nombre; } public void setNombre(String value) { this.nombre=value; }
    public String getCorreo() { return correo; } public void setCorreo(String value) { this.correo=value; }
    public String getTelefono() { return telefono; } public void setTelefono(String value) { this.telefono=value; }
 }