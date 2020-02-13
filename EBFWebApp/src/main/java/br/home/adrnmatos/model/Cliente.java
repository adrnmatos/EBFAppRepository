package br.home.adrnmatos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	private Long id;

	@NotNull
	@Size(
			min=2,
			max=255,
			message="Name is required, maximum 255 characters.")
	private String nome;
	
	private int identidade;
	
	private int cpf;
	
	private Endereco endereco;
	
	private String email;
	
	private int telefone1;
	
	private int telefone2;
	
	public Cliente() {
		
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

	public int getIdentidade() {
		return identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(int telefone1) {
		this.telefone1 = telefone1;
	}

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
