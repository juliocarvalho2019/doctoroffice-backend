package com.julio.doctoroffice.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.julio.doctoroffice.domain.enums.Perfil;

@Entity
public class Paciente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	
	private List<Consulta> consultas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "paciente")
	public List<Consulta> getConsultas() {
		return consultas;
	}
	
	public Paciente() {
		super();
		addPerfil(Perfil.PACIENTE);
	}

	public Paciente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.PACIENTE);
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	
}
