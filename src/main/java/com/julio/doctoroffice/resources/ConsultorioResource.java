package com.julio.doctoroffice.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.julio.doctoroffice.domain.Consultorio;
import com.julio.doctoroffice.domain.dtos.ConsultorioDTO;
import com.julio.doctoroffice.services.ConsultorioService;

@RestController
@RequestMapping(value ="/consultorios")
public class ConsultorioResource {
	
	//localhost:8080/consultorios
	
	@Autowired
	private ConsultorioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConsultorioDTO> findByid(@PathVariable Integer id){
		Consultorio obj = service.findById(id);
		return ResponseEntity.ok().body(new ConsultorioDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultorioDTO>>findAll(){
		List<Consultorio> list = service.findAll();
		List<ConsultorioDTO> listDTO = list.stream().map(obj -> new ConsultorioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ConsultorioDTO> create(@Valid @RequestBody ConsultorioDTO objDTO){
		Consultorio newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ConsultorioDTO>update(@PathVariable Integer id, @Valid @RequestBody ConsultorioDTO objDTO){
		Consultorio obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ConsultorioDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ConsultorioDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
