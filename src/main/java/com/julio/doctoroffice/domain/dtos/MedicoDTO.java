package com.julio.doctoroffice.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.julio.doctoroffice.domain.Medico;
import com.julio.doctoroffice.domain.enums.Perfil;

public class MedicoDTO implements Serializable{
	
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
	
	@NotNull(message = "O campo crm é obrigatório!")
    private String crm;
	@NotNull(message = "O campo especialidade é obrigatório!")
	private String especialidade;
	@NotNull(message = "O campo idade é obrigatório!")
	private Integer idade;
	
	public MedicoDTO() {
		super();
		addPerfil(Perfil.PACIENTE);
	}

	public MedicoDTO(Medico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		
		this.crm = obj.getCrm();
		this.especialidade = obj.getEspecialidade();
		this.idade = obj.getIdade();
		
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
	
}
