package com.julio.doctoroffice.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.julio.doctoroffice.domain.enums.Prioridade;
import com.julio.doctoroffice.domain.enums.Status;

@Entity
public class Consulta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	private Prioridade prioridade;
	private Status status;
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "consultorio_id")
	private Consultorio consultorio;
	
	
	public Consulta() {
		super();
	}

	

	public Consulta(Integer id, Prioridade prioridade, Status status, Medico medico, Paciente paciente,
			Consultorio consultorio) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.medico = medico;
		this.paciente = paciente;
		this.consultorio = consultorio;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDate getDataAbertura() {
		return dataAbertura;
	}



	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



	public LocalDate getDataFechamento() {
		return dataFechamento;
	}



	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}



	public Prioridade getPrioridade() {
		return prioridade;
	}



	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}



	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(id, other.id);
	}

	
}
