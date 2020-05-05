package com.vicente.cadastro.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	public Funcionario() {}
	
	public Funcionario(Long id, @NotEmpty @Size(max = 80) String nome,
			@NotEmpty @Size(max = 80) String funcao,  @NotNull Boolean ativo, BigDecimal salario) {
		
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.ativo= ativo;
		this.salario = salario;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(max = 80)
	@Column(name = "nome")
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	@NotEmpty
	@Size(max = 80)
	@Column(name = "funcao")
	private String funcao; 
	
	@Column(name = "salario")
	private BigDecimal salario;
	
	@NotNull
	private Boolean ativo;
	
	public Funcionario(@NotEmpty @Size(max = 80) String nome, 
			@NotEmpty @Size(max = 80) String funcao, @NotNull Boolean ativo,
			BigDecimal salario) {
		super();
		this.nome = nome;
		this.funcao = funcao;
		this.ativo = ativo;
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
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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