package com.julio.doctoroffice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Consultorio;
import com.julio.doctoroffice.domain.dtos.ConsultorioDTO;
import com.julio.doctoroffice.repositories.ConsultorioRepository;
import com.julio.doctoroffice.services.exceptions.DataIntegrityVioalationException;
import com.julio.doctoroffice.services.exceptions.ObjectnotFoundException;

@Service
public class ConsultorioService {
 
	@Autowired
	private ConsultorioRepository repository;
	
	public Consultorio findById(Integer id) {
		Optional<Consultorio> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Consultorio> findAll() {
		return repository.findAll();
	}

	public Consultorio create(ConsultorioDTO objDTO) {
		objDTO.setId(null);
		Consultorio newObj = new Consultorio(objDTO);
		return repository.save(newObj);
	}
	
	public Consultorio update(Integer id, ConsultorioDTO objDTO) {
		objDTO.setId(id);
		Consultorio oldObj = findById(id);
		oldObj = new Consultorio(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {	
		List<Consultorio> consultorios = findAll();
		for (Consultorio consultorio : consultorios) {
			if(consultorios.contains(id)) {
				repository.deleteById(id);		
			}else {
				throw new DataIntegrityVioalationException("Objeto não encontrado! Id: " + id);
			}
		}	
	}	
}
