package com.julio.doctoroffice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julio.doctoroffice.domain.Medico;

public interface  MedicoRepository extends JpaRepository<Medico, Integer>{
	Optional<Medico> findByCrm(String crm);

}
