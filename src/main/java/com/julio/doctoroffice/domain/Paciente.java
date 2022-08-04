package com.julio.doctoroffice.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.julio.doctoroffice.domain.dtos.PacienteDTO;
import com.julio.doctoroffice.domain.enums.Perfil;

@Entity
public class Paciente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas = new ArrayList<>();

	public Paciente() {
		super();
		addPerfil(Perfil.PACIENTE);
	}
	
	public Paciente(PacienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}


	public Paciente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.PACIENTE);
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}
	
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	

	
}
