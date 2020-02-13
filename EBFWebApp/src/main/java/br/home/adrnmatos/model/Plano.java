package br.home.adrnmatos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plano {
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	private Long id;
	
	private String nome;
	
	private Long calendarioId;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCalendarioId() {
		return calendarioId;
	}

	public void setCalendarioId(Long calendarioId) {
		this.calendarioId = calendarioId;
	}
	

}
