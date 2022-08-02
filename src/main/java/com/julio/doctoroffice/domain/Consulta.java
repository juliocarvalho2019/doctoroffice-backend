package com.julio.doctoroffice.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.julio.doctoroffice.domain.enums.Prioridade;
import com.julio.doctoroffice.domain.enums.Status;

public class Consulta {
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	
	private Paciente paciente;
	private Medico medico;
	private List<Medico> listaMedico;
	private Consultorio consultorio;
	
	
	
	public Consulta() {
		super();
	}



	public Consulta(Integer id, Prioridade prioridade, Status status, Paciente paciente, Medico medico,
			List<Medico> listaMedico, Consultorio consultorio) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.paciente = paciente;
		this.medico = medico;
		this.listaMedico = listaMedico;
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



	public List<Medico> getListaMedico() {
		return listaMedico;
	}



	public void setListaMedico(List<Medico> listaMedico) {
		this.listaMedico = listaMedico;
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



	@Override
	public String toString() {
		return "Consulta [id=" + id + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento
				+ ", prioridade=" + prioridade + ", status=" + status + ", paciente=" + paciente + ", medico=" + medico
				+ ", listaMedico=" + listaMedico + ", consultorio=" + consultorio + "]";
	}
	
	


}
