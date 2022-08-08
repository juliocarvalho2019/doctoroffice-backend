package com.julio.doctoroffice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Paciente;
import com.julio.doctoroffice.domain.Pessoa;
import com.julio.doctoroffice.domain.dtos.PacienteDTO;
import com.julio.doctoroffice.repositories.PacienteRepository;
import com.julio.doctoroffice.repositories.PessoaRepository;
import com.julio.doctoroffice.services.exceptions.DataIntegrityVioalationException;
import com.julio.doctoroffice.services.exceptions.ObjectnotFoundException;

@Service
public class PacienteService {
 
	@Autowired
	private PacienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Paciente findById(Integer id) {
		Optional<Paciente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Paciente> findAll() {
		return repository.findAll();
	}

	public Paciente create(PacienteDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validate(objDTO);
		Paciente newObj = new Paciente(objDTO);
		return repository.save(newObj);
	}
	
	public Paciente update(Integer id, @Valid PacienteDTO objDTO) {
		objDTO.setId(id);
		Paciente oldObj = findById(id);
		
		if(!objDTO.getSenha().equals(oldObj.getSenha())) 
			objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		
		validate(objDTO);
		oldObj = new Paciente(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Paciente obj = findById(id);
		
		if(obj.getConsultas().size() > 0 ) {
			throw new DataIntegrityVioalationException("Paciente possui consultas agendadas e não pode ser deletado!");
		}else {
			repository.deleteById(id);
		}
		
	}

	private void validate(PacienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityVioalationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityVioalationException("E-mail já cadastrado no sistema!");
		}
		
	}



	
}
