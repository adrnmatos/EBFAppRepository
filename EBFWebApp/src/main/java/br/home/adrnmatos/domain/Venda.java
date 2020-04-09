package br.home.adrnmatos.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "venda")
@org.hibernate.annotations.Immutable
public class Venda {
	
	@EmbeddedId
	protected VendaId id = new VendaId();
		
	@Column(updatable = false)
	@NotNull
	protected LocalDateTime addedOn;
	
	@ManyToOne
	@JoinColumn(
		name = "cliente_id",
		insertable = false, updatable = false)
	protected Cliente cliente;
	
	@ManyToOne
	@JoinColumn(
		name = "plano_id",
		insertable = false, updatable = false)
	protected Plano plano;
	
	@ManyToOne
	@JoinColumn(
		name = "usuario_id",
		insertable = false, updatable = false)
	protected Usuario usuario;

	
	public Venda() {		
	}

	public Venda(Cliente cliente, Plano plano, Usuario usuario) {
		
		this.cliente = cliente;
		this.plano = plano;
		this.usuario = usuario;
		
		this.id.clienteId = cliente.getId();
		this.id.planoId = plano.getId();
		
		cliente.getVendas().add(this);
		plano.getVendas().add(this);
		usuario.getVendas().add(this);
	}
	
	public VendaId getId() {
		return id;
	}

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
