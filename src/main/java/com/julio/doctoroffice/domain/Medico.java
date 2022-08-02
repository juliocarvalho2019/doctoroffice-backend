package com.julio.doctoroffice.domain;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa{
	private String crm;
	private String especialidade;
	private Integer idade;
	
	private List<Consulta> consultas = new ArrayList<>();

	public Medico() {
		super();
	}

	public Medico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
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

	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", especialidade=" + especialidade + ", idade=" + idade + ", consultas="
				+ consultas + "]";
	}
	
	
	

}
