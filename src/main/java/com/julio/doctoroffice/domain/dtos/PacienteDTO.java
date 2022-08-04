package com.julio.doctoroffice.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.julio.doctoroffice.domain.Paciente;
import com.julio.doctoroffice.domain.enums.Perfil;

public class PacienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	
	@NotNull(message = "O campo nome é obrigatório!")
	protected String nome;
	@NotNull(message = "O campo cpf é obrigatório!")
	protected String cpf;
	@NotNull(message = "O campo e-mail é obrigatório!")
	protected String email;
	@NotNull(message = "O campo senha é obrigatório!")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	public PacienteDTO() {
		super();
		addPerfil(Perfil.PACIENTE);
	}

	public PacienteDTO(Paciente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		
		addPerfil(Perfil.PACIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
