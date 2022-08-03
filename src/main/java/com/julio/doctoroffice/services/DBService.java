package com.julio.doctoroffice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.doctoroffice.domain.Consulta;
import com.julio.doctoroffice.domain.Consultorio;
import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.domain.Paciente;
import com.julio.doctoroffice.domain.enums.Perfil;
import com.julio.doctoroffice.domain.enums.Prioridade;
import com.julio.doctoroffice.domain.enums.Status;
import com.julio.doctoroffice.repositories.ConsultaRepository;
import com.julio.doctoroffice.repositories.ConsultorioRepository;
import com.julio.doctoroffice.repositories.MedicoRepository;
import com.julio.doctoroffice.repositories.PacienteRepository;

@Service
public class DBService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ConsultorioRepository consultorioRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;

	
	public void instaciaDB() {
		Medico med1 = new Medico(null, "Marco Antônio Marques Félix", "16770751046","marco@mail.com", "123", "CRM/SP 123456", "Cirurgião", 30);
		med1.addPerfil(Perfil.MEDICO);
		
		Medico med2 = new Medico(null, "Fernando da Silva", "94786182028","fernando@mail.com", "123", "CRM/SP 123463", "Clinico Geral", 28);
		med2.addPerfil(Perfil.MEDICO);
		
		Medico med3 = new Medico(null, "Sergio Gianini", "87607961038","sergio@mail.com", "123", "CRM/SP 123452", "Obstetra", 32);
		med3.addPerfil(Perfil.MEDICO);
		
		Paciente pac1 = new Paciente(null, "João Antônio Filho","64015114000", "joao@email.com", "123");
		pac1.addPerfil(Perfil.PACIENTE);
		
		Paciente pac2 = new Paciente(null, "Roberval da Silva","39937105099", "roberval@email.com", "123");
		pac2.addPerfil(Perfil.PACIENTE);
		
		Paciente pac3 = new Paciente(null, "Pedro José","91105408060", "pedrojose@email.com", "123");
		pac3.addPerfil(Perfil.PACIENTE);
		
		Consultorio cons1 = new Consultorio(null, 1);
		
		Consultorio cons2 = new Consultorio(null, 2);
		
		Consultorio cons3 = new Consultorio(null, 3);
		
		Consulta consult1 = new Consulta(null, Prioridade.MEDIA, Status.ANDAMENTO, med1, pac1, cons1);
	
		Consulta consult2 = new Consulta(null, Prioridade.BAIXA,Status.ABERTO, med2, pac2, cons2);
		
		Consulta consult3 = new Consulta(null, Prioridade.MEDIA,Status.ANDAMENTO, med3, pac3, cons3);
		
		medicoRepository.saveAll(Arrays.asList(med1, med2, med3));
		pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3));
		consultorioRepository.saveAll(Arrays.asList(cons1, cons2, cons3 ));
		consultaRepository.saveAll(Arrays.asList(consult1, consult2, consult3));
	}

}
