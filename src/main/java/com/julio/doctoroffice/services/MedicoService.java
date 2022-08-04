package com.julio.doctoroffice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.repositories.MedicoRepository;
import com.julio.doctoroffice.services.exceptions.ObjectnotFoundException;

@Service
public class MedicoService {
 
	@Autowired
	private MedicoRepository repository;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Medico> findAll() {
		return repository.findAll();
	}
}
