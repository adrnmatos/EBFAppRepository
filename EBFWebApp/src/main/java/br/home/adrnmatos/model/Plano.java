package br.home.adrnmatos.model;

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
	private Long id;
	
	private String nome;
	
	private Long calendarioId;
	
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
