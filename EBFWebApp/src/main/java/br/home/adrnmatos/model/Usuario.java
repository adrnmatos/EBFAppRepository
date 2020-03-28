package br.home.adrnmatos.model;

import java.time.LocalDateTime;
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
	private Long id;
	
	@NotNull	
	@Size(
			min=2,
			max=255,
			message="Name is required, maximum 255 characters.")
	private String nome;
	
	private Endereco endereco;
	
	private Cargo cargo;
	
	private LocalDateTime dataAdmissao;
	
	private LocalDateTime dataRecisao;
	
	@OneToMany(mappedBy = "usuario")
	protected Set<Venda> vendas = new HashSet<>();

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

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDateTime getDataRecisao() {
		return dataRecisao;
	}

	public void setDataRecisao(LocalDateTime dataRecisao) {
		this.dataRecisao = dataRecisao;
	}

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}
	
	
}
