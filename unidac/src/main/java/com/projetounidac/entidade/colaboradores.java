package com.projetounidac.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbcolaboradores")
public class colaboradores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="cafemanha")
	private List<String> cafeManha;
	
	@Override
	public String toString() {
		return "Colaborador [Café da Manhã=" + cafeManha + ", nome=" + nome + ", cpf=" + cpf + "]";
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

	public List<String> getCafeManha() {
		return cafeManha;
	}

	public void setCafeManha(List<String> cafeManha) {
		this.cafeManha = cafeManha;
	}

	public colaboradores(Long id, String nome, String cpf, List<String> cafeManha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cafeManha = cafeManha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
