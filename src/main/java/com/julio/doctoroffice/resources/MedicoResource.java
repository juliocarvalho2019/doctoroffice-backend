package com.julio.doctoroffice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.services.MedicoService;

@RestController
@RequestMapping(value ="/medicos")
public class MedicoResource {
	
	//localhost:8080/medicos
	
	@Autowired
	private MedicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Medico> findByid(@PathVariable Integer id){
		Medico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
