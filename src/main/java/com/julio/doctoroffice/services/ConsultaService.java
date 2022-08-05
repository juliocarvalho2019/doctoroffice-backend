package com.julio.doctoroffice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Consulta;
import com.julio.doctoroffice.domain.Consultorio;
import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.domain.Paciente;
import com.julio.doctoroffice.domain.dtos.ConsultaDTO;
import com.julio.doctoroffice.domain.enums.Prioridade;
import com.julio.doctoroffice.domain.enums.Status;
import com.julio.doctoroffice.repositories.ConsultaRepository;
import com.julio.doctoroffice.services.exceptions.ObjectnotFoundException;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ConsultorioService consultorioService;
	
	public Consulta findById(Integer id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Consulta> findAll() {
		return repository.findAll();
	}



	public Consulta create(@Valid ConsultaDTO objDTO) {
		return repository.save(newConsulta(objDTO));
		
	}
	
	private Consulta newConsulta(ConsultaDTO obj) {
		Medico medico = medicoService.findById(obj.getMedico());
		Paciente paciente = pacienteService.findById(obj.getPaciente());
		Consultorio consultorio = consultorioService.findById(obj.getConsultorio());		
		Consulta consulta = new Consulta();
		if(obj.getId() != null) {
			consulta.setId(obj.getId());
		}
		
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setConsultorio(consultorio);
		consulta.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		consulta.setStatus(Status.toEnum(obj.getStatus()));
		return consulta;
		
	}
	

}
