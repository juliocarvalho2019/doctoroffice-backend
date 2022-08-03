package com.julio.doctoroffice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

@SpringBootApplication
public class DoctorofficeApplication implements CommandLineRunner{
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ConsultorioRepository consultorioRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoctorofficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Medico med1 = new Medico(null, "Marco Antônio Marques Félix", "16770751046","marco@mail.com", "123", "CRM/SP 123456", "Cirurgião", 30);
		med1.addPerfil(Perfil.MEDICO);
		
		Paciente pac1 = new Paciente(null, "João Antônio Filho","64015114000", "joao@email.com", "123");
		pac1.addPerfil(Perfil.PACIENTE);
		
		Consultorio cons1 = new Consultorio(null, 1);
		
		Consulta consult1 = new Consulta(null, Prioridade.MEDIA,Status.ANDAMENTO, pac1, med1, pac1, cons1);
		
		medicoRepository.saveAll(Arrays.asList(med1));
		pacienteRepository.saveAll(Arrays.asList(pac1));
		consultorioRepository.saveAll(Arrays.asList(cons1));
		consultaRepository.saveAll(Arrays.asList(consult1));
		
		
	}

}
