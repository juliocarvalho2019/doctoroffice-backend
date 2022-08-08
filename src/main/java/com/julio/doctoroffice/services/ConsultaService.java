package com.julio.doctoroffice.services;

import java.time.LocalDate;
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
	//@Autowired
	//private MedicoRepository medicorepository;

	// @Autowired
	// private PessoaRepository pessoaRepository;

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
		//validate(objDTO);
		return repository.save(newConsulta(objDTO));

	}

	public Consulta update(Integer id, @Valid ConsultaDTO objDTO) {
		objDTO.setId(id);
		Consulta oldObj = findById(id);
		oldObj = newConsulta(objDTO);
		return repository.save(oldObj);
	}

	private Consulta newConsulta(ConsultaDTO obj) {
		Medico medico = medicoService.findById(obj.getMedico());
		Paciente paciente = pacienteService.findById(obj.getPaciente());
		Consultorio consultorio = consultorioService.findById(obj.getConsultorio());
		Consulta consulta = new Consulta();

		if (obj.getId() != null) {
			consulta.setId(obj.getId());
		}

		if (obj.getStatus().equals(2)) {
			consulta.setDataFechamento(LocalDate.now());
		}

		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setConsultorio(consultorio);
		consulta.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		consulta.setStatus(Status.toEnum(obj.getStatus()));
		return consulta;

	}

//	private void validate(ConsultaDTO objDTO) {
//
//		List<Consulta> listaConsultas = repository.findAll();
//		List<Medico> listaMedicos = medicorepository.findAll();
//
//		boolean medicoCadatrado = false;
//		boolean consultaCadatrada = false;
//		boolean consultorioCadastrado = false;
//		boolean mesmaDataConsulta = false;
//
//		for (int i = 0; i < listaMedicos.size(); i++) {
//			if ((listaMedicos.get(i).getId().equals(objDTO.getMedico()))) {
//				medicoCadatrado = true;
//			//	throw new DataIntegrityVioalationException("Médico já cadastrada!");
//			}
//		}
//
//		for (int i = 0; i < listaConsultas.size(); i++) {
//			if ((listaConsultas.get(i).getId().equals(objDTO.getId()))) {
//				consultaCadatrada = true;
//			//	throw new DataIntegrityVioalationException("Consulta já cadastrada!");
//			}
//		}
//
//		for (int i = 0; i < listaConsultas.size(); i++) {
//			if ((listaConsultas.get(i).getDataAbertura().equals(objDTO.getDataAbertura()))) {
//				mesmaDataConsulta = true;
//			 //   throw new DataIntegrityVioalationException("consultorio já cadastrada!");
//			}
//		}
//		
//		for (int i = 0; i < listaConsultas.size(); i++) {
//			if ((listaConsultas.get(i).getConsultorio().getId().equals(objDTO.getConsultorio()))) {
//				consultorioCadastrado = true;
//			//	throw new DataIntegrityVioalationException("Consulta já cadastrada!");
//			}
//		}
//		
//		if(medicoCadatrado && consultaCadatrada && mesmaDataConsulta && consultorioCadastrado) {
//			throw new DataIntegrityVioalationException("Já existe consulta cadastrada neste horário!");
//		}
//
//	}
}
