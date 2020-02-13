package br.home.adrnmatos.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	private Long id;
	
	private Long clienteId;
	
	private Long planoId;
	
	private LocalDateTime data;
	
	private Long valor;

	public Long getId() {
		return id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getPlanoId() {
		return planoId;
	}

	public void setPlanoId(Long planoId) {
		this.planoId = planoId;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	
}
