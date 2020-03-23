package br.home.adrnmatos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(nullable = true)
	private String rua;
	
	@Column(nullable = true)
	private int numero;
	
	@Column(nullable = true)
	private String complemento;
	
	@Column(nullable = true)
	private String bairro;
	
	@Column(nullable = true)
	private int cep;
	
	@Column(nullable = true)
	private String cidade;
	
	@Column(nullable = true)
	private String estado;
	
	@Column(nullable = true)
	private String pais;
	
	public Endereco() {
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


}
