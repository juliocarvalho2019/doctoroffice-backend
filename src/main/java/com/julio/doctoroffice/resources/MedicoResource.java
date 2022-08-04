package com.julio.doctoroffice.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.domain.dtos.MedicoDTO;
import com.julio.doctoroffice.services.MedicoService;

@RestController
@RequestMapping(value ="/medicos")
public class MedicoResource {
	
	//localhost:8080/medicos
	
	@Autowired
	private MedicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicoDTO> findByid(@PathVariable Integer id){
		Medico obj = service.findById(id);
		return ResponseEntity.ok().body(new MedicoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<MedicoDTO>>findAll(){
		List<Medico> list = service.findAll();
		List<MedicoDTO> listDTO = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<MedicoDTO> create(@Valid @RequestBody MedicoDTO objDTO){
		Medico newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MedicoDTO>update(@PathVariable Integer id, @Valid @RequestBody MedicoDTO objDTO){
		Medico obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new MedicoDTO(obj));
	}

}
