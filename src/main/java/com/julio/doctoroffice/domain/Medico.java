package com.julio.doctoroffice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.julio.doctoroffice.domain.enums.Perfil;


@Entity
public class Medico extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String crm;
	
	private String especialidade;
	private Integer idade;
	
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();

	public Medico() {
		super();
		addPerfil(Perfil.PACIENTE);
	}

	public Medico(Integer id, String nome, String cpf, String email, String senha,String crm, String especialidade, Integer idade) {
		super(id, nome, cpf, email, senha);
		this.crm = crm;
		this.especialidade = especialidade;
		this.idade = idade;
		addPerfil(Perfil.PACIENTE);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}	

}
