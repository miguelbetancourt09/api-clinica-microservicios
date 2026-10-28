package com.ejemplo.pacientesservice.repository;
 import com.ejemplo.pacientesservice.entity.Paciente; import org.springframework.data.jpa.repository.JpaRepository;
 public interface PacienteRepository extends JpaRepository<Paciente, Long> {}