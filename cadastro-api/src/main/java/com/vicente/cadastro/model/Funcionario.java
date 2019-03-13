package com.vicente.cadastro.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Funcionario {
	
	public Funcionario() {}
	
	public Funcionario(Long id, @NotEmpty @Size(max = 80) String nome,
			@NotEmpty @Size(max = 80) String funcao, BigDecimal salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.salario = salario;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(max = 80)
	@Column(name = "nome_funcionario")
	private String nome;
	
	@NotEmpty
	@Size(max = 80)
	@Column(name = "funcao_funcionario")
	private String funcao; 
	
	@Column(name = "salario_funcionario")
	private BigDecimal salario;
	
	public Funcionario(@NotEmpty @Size(max = 80) String nome, @NotEmpty @Size(max = 80) String funcao,
			BigDecimal salario) {
		super();
		this.nome = nome;
		this.funcao = funcao;
		this.salario = salario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}