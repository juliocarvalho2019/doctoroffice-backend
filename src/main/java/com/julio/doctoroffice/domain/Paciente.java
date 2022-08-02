package com.julio.doctoroffice.domain;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{

	private List<Consulta> consultas = new ArrayList<>();

	public Paciente() {
		super();
	}

	public Paciente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public String toString() {
		return "Paciente [consultas=" + consultas + "]";
	}
	
	
	
}
