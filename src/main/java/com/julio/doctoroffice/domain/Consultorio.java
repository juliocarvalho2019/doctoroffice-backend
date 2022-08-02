package com.julio.doctoroffice.domain;

public class Consultorio {
	
	private Integer numeroConsultorio;

	public Integer getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(Integer numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	@Override
	public String toString() {
		return "Consultorio [numeroConsultorio=" + numeroConsultorio + "]";
	}
	
}
