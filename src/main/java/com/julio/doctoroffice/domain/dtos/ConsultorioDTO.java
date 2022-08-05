package com.julio.doctoroffice.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.julio.doctoroffice.domain.Consultorio;

public class ConsultorioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	
	@NotNull(message = "O campo número Consultório é obrigatório!")
	protected Integer numeroConsultorio;
	
	public ConsultorioDTO() {
		super();
	}

	public ConsultorioDTO(Consultorio obj) {
		super();
		this.id = obj.getId();
		this.numeroConsultorio = obj.getNumeroConsultorio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(Integer numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	
	
}
