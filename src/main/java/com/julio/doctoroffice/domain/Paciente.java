package com.julio.doctoroffice.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.julio.doctoroffice.domain.enums.Perfil;

@Entity
public class Paciente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	
	private List<Consulta> consultas = new ArrayList<>();

	public Paciente() {
		super();
		addPerfil(Perfil.PACIENTE);
	}

	public Paciente(List<Consulta> consultas) {
		super();
		this.consultas = consultas;
		addPerfil(Perfil.PACIENTE);
	}

	@OneToMany(mappedBy = "paciente")
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	
}
