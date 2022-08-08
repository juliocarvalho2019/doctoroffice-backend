package com.julio.doctoroffice.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julio.doctoroffice.domain.Consulta;

public interface  ConsultaRepository extends JpaRepository<Consulta, Integer>{
	Optional<Consulta> findByMedico(Integer id);
	Optional<Consulta> findByPaciente(Integer id);
	Optional<Consulta> findByDataAbertura(LocalDate dataAbertura);
	Optional<Consulta> findById(Integer id);

}
