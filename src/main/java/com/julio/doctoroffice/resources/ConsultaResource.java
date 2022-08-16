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

import com.julio.doctoroffice.domain.Consulta;
import com.julio.doctoroffice.domain.dtos.ConsultaDTO;
import com.julio.doctoroffice.services.ConsultaService;

@RestController
//@Api(value="Mostra Lista de consultas")
@RequestMapping(value = "/consultas")
public class ConsultaResource {
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConsultaDTO> findById(@PathVariable Integer id){
		Consulta obj = service.findById(id);
		return ResponseEntity.ok().body(new ConsultaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> findAll(){
		List<Consulta> list = service.findAll();
		List<ConsultaDTO> listDTO = list.stream().map(obj -> new ConsultaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ConsultaDTO> create(@Valid @RequestBody ConsultaDTO objDTO){
		Consulta obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ConsultaDTO> update(@PathVariable Integer id, @Valid @RequestBody ConsultaDTO objDTO){
		Consulta newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ConsultaDTO(newObj));
		
	}

}
