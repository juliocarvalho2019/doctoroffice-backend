package com.julio.doctoroffice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.julio.doctoroffice.domain.dtos.ConsultorioDTO;

@Entity
public class Consultorio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numeroConsultorio;
	
	@OneToMany(mappedBy = "consultorio")
	private List<Consulta> consultas = new ArrayList<>();
	
	

	public Consultorio() {
		super();
	}
	
	public Consultorio(ConsultorioDTO obj) {
		super();
		this.id = obj.getId();
		this.numeroConsultorio = obj.getNumeroConsultorio();
	}

	
	public Consultorio(Integer id, Integer numeroConsultorio) {
		super();
		this.id = id;
		this.numeroConsultorio = numeroConsultorio;
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
