package com.julio.doctoroffice.services;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	

	public void instaciaDB() {
		Medico med1 = new Medico(null, "Marco Antônio Marques Félix", "16770751046","marco@mail.com", encoder.encode("123"), "CRM/SP 123456", "Cirurgião", 30);
		med1.addPerfil(Perfil.MEDICO);
		
		Medico med2 = new Medico(null, "Fernando da Silva", "94786182028","fernando@mail.com",encoder.encode("123"), "CRM/SP 123463", "Clinico Geral", 28);
		med2.addPerfil(Perfil.MEDICO);
		
		Medico med3 = new Medico(null, "Sergio Gianini", "87607961038","sergio@mail.com",encoder.encode("123"), "CRM/SP 123452", "Obstetra", 32);
		med3.addPerfil(Perfil.MEDICO);
		
		Paciente pac1 = new Paciente(null, "João Antônio Filho","64015114000", "joao@email.com", encoder.encode("123"));
		pac1.addPerfil(Perfil.PACIENTE);
		
		Paciente pac2 = new Paciente(null, "Roberval da Silva","39937105099", "roberval@email.com", encoder.encode("123"));
		pac2.addPerfil(Perfil.PACIENTE);
		
		Paciente pac3 = new Paciente(null, "Pedro José","91105408060", "pedrojose@email.com", encoder.encode("123"));
		pac3.addPerfil(Perfil.PACIENTE);
		
		Consultorio cons1 = new Consultorio(null, 1);
		Consultorio cons2 = new Consultorio(null, 2);
		Consultorio cons3 = new Consultorio(null, 3);
		Consultorio cons4 = new Consultorio(null, 4);
		Consultorio cons5 = new Consultorio(null, 5);
		Consultorio cons6 = new Consultorio(null, 6);
		Consultorio cons7 = new Consultorio(null, 7);
		Consultorio cons8 = new Consultorio(null, 8);
		Consultorio cons9 = new Consultorio(null, 9);
		Consultorio cons10 = new Consultorio(null, 10);
		
		
		Consulta consult1 = new Consulta(null, Prioridade.MEDIA,  Status.ANDAMENTO, med1, pac1, cons1);
		
		Consulta consult2 = new Consulta(null, Prioridade.MEDIA, Status.ANDAMENTO, med1, pac1, cons1);
	
		Consulta consult3 = new Consulta(null, Prioridade.BAIXA,Status.ABERTO, med2, pac2, cons2);
		
		Consulta consult4 = new Consulta(null, Prioridade.MEDIA,Status.ANDAMENTO, med3, pac3, cons3);
		
		medicoRepository.saveAll(Arrays.asList(med1, med2, med3));
		pacienteRepository.saveAll(Arrays.asList(pac1, pac2, pac3));
		consultorioRepository.saveAll(Arrays.asList(cons1, cons2, cons3,cons4,cons5,cons6,cons7,cons8,cons9,cons10 ));
		consultaRepository.saveAll(Arrays.asList(consult1, consult2, consult3, consult4));
	}

}
