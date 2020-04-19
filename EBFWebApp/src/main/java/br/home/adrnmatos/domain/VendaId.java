package br.home.adrnmatos.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class VendaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cliente_id")
	protected Long clienteId;
	
	@Column(name = "plano_id")
	protected Long planoId;
	
	@Column(name = "addedOn")
	protected LocalDateTime addedOn = LocalDateTime.now();
	
	public VendaId() {
	}
	
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof VendaId) {
			VendaId that = (VendaId)obj;
			return this.clienteId.equals(that.clienteId)
					&& this.planoId.equals(that.planoId)
					&& this.addedOn.equals(that.addedOn);
		}
		return false;
	}
	
	public int hashCode() {
		return clienteId.hashCode() + planoId.hashCode() + addedOn.hashCode();
	}

	
}
