package com.julio.doctoroffice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.domain.Pessoa;
import com.julio.doctoroffice.domain.dtos.MedicoDTO;
import com.julio.doctoroffice.repositories.MedicoRepository;
import com.julio.doctoroffice.repositories.PessoaRepository;
import com.julio.doctoroffice.services.exceptions.DataIntegrityVioalationException;
import com.julio.doctoroffice.services.exceptions.ObjectnotFoundException;

@Service
public class MedicoService {
 
	@Autowired
	private MedicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Medico create(MedicoDTO objDTO) {
		objDTO.setId(null);
		validate(objDTO);
		Medico newObj = new Medico(objDTO);
		return repository.save(newObj);
	}
	
	public Medico update(Integer id, @Valid MedicoDTO objDTO) {
		objDTO.setId(id);
		Medico oldObj = findById(id);
		validate(objDTO);
		oldObj = new Medico(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Medico obj = findById(id);
		
		if(obj.getConsultas().size() > 0 ) {
			throw new DataIntegrityVioalationException("Médico possui consultas agendadas e não pode ser deletado!");
		}else {
			repository.deleteById(id);
		}
		
	}

	private void validate(MedicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityVioalationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityVioalationException("E-mail já cadastrado no sistema!");
		}
		
		Optional<Medico> obj1 = repository.findByCrm(objDTO.getCrm());
		if(obj1.isPresent() && obj1.get().getId() != objDTO.getId()) {
			throw new DataIntegrityVioalationException("CRM já cadastrado no sistema!");
		}
		
		
	}



	
}
