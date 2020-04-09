package br.home.adrnmatos.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plano {
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	protected Long id;
	
	protected String nome;
	
	protected Long calendarioId;
	
	@OneToMany(mappedBy = "plano")
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

	public Long getCalendarioId() {
		return calendarioId;
	}

	public void setCalendarioId(Long calendarioId) {
		this.calendarioId = calendarioId;
	}

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}
	

}
