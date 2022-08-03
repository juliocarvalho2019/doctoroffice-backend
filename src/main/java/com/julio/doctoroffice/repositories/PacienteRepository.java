package com.julio.doctoroffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julio.doctoroffice.domain.Paciente;

public interface  PacienteRepository extends JpaRepository<Paciente, Integer>{

}
