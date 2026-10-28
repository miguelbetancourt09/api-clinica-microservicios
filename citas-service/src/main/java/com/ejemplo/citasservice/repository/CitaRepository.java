package com.ejemplo.citasservice.repository;
 import com.ejemplo.citasservice.entity.Cita; import org.springframework.data.jpa.repository.JpaRepository;
 public interface CitaRepository extends JpaRepository<Cita, Long> {}