package br.home.adrnmatos.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HistoricoPlano {
	
	@Id
	private Long id;
	
	private Long planoId;
	
	private Float valor;
	
	/*
	 * private Agenda agenda;
	 */	
	private LocalDateTime dataCadastro;

	public Long getId() {
		return id;
	}

	public Long getPlanoId() {
		return planoId;
	}

	public void setPlanoId(Long planoId) {
		this.planoId = planoId;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	/*
	 * public Agenda getAgenda() { return agenda; }
	 * 
	 * public void setAgenda(Agenda agenda) { this.agenda = agenda; }
	 */
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
}
