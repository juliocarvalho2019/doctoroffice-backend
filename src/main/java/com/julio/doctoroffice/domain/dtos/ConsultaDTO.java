package com.julio.doctoroffice.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.julio.doctoroffice.domain.Consulta;

public class ConsultaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	@NotNull(message = "O campo prioridade é obrigatório!")
	private Integer prioridade;
	@NotNull(message = "O campo status é obrigatório!")
	private Integer status;
	@NotNull(message = "O campo médico é obrigatório!")
	private Integer medico;
	@NotNull(message = "O campo paciente é obrigatório!")
	private Integer paciente;
	@NotNull(message = "O campo consultório é obrigatório!")
	private Integer consultorio;
	private String nomeMedico;
	private String nomePaciente;
	private String numeroConsultorio;
	
	public ConsultaDTO() {
		super();
	}

	public ConsultaDTO(Consulta obj) {
		super();
		this.id = obj.getId();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.medico = obj.getMedico().getId();
		this.paciente = obj.getPaciente().getId();
		this.consultorio = obj.getConsultorio().getId();
		this.nomeMedico = obj.getMedico().getNome();
		this.nomePaciente = obj.getPaciente().getNome();
		this.numeroConsultorio = obj.getConsultorio().getNumeroConsultorio().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMedico() {
		return medico;
	}

	public void setMedico(Integer medico) {
		this.medico = medico;
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public Integer getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Integer consultorio) {
		this.consultorio = consultorio;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}
	
	
	
	
}
