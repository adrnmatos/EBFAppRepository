package br.home.adrnmatos.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	protected Long id;
	
	@NotNull	
	@Size(
			min=2,
			max=255,
			message="Name is required, maximum 255 characters.")
	protected String nome;
	
	protected Endereco endereco;
	
	protected Cargo cargo;
	
	protected LocalDate dataAdmissao;
	
	protected LocalDate dataRecisao;
	
	protected String login;
	
	protected String senha;
	
	@OneToMany(mappedBy = "usuario")
	protected Set<Venda> vendas = new HashSet<>();

	public Usuario() {
		this.endereco = new Endereco();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataRecisao() {
		return dataRecisao;
	}

	public void setDataRecisao(LocalDate dataRecisao) {
		this.dataRecisao = dataRecisao;
	}

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
