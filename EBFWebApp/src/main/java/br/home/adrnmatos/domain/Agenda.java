package br.home.adrnmatos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agenda {
	
	@Id
	protected Long id;
	
	protected Long planoId;

	public Long getId() {
		return id;
	}

	public Long getPlanoId() {
		return planoId;
	}

	public void setPlanoId(Long planoId) {
		this.planoId = planoId;
	}
	

}
