package com.ejemplo.citasservice.entity;
 import jakarta.persistence.*;
 @Entity @Table(name="citas") public class Cita {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
     @jakarta.validation.constraints.NotNull private Long pacienteId;
    @jakarta.validation.constraints.NotBlank private String fecha;
    @jakarta.validation.constraints.NotBlank private String motivo;
 public Long getId() {return id;} public void setId(Long id) {this.id=id;}
     public Long getPacienteId() { return pacienteId; } public void setPacienteId(Long value) { this.pacienteId=value; }
    public String getFecha() { return fecha; } public void setFecha(String value) { this.fecha=value; }
    public String getMotivo() { return motivo; } public void setMotivo(String value) { this.motivo=value; }
 }