package com.julio.doctoroffice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Consulta;
import com.julio.doctoroffice.repositories.ConsultaRepository;
import com.julio.doctoroffice.services.exceptions.ObjectnotFoundException;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	public Consulta findById(Integer id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}
	

}
