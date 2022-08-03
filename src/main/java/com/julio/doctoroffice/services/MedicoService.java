package com.julio.doctoroffice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.repositories.MedicoRepository;

@Service
public class MedicoService {
 
	@Autowired
	private MedicoRepository repository;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
