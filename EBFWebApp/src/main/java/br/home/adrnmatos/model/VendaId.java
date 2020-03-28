package br.home.adrnmatos.model;

import java.io.Serializable;

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
	
	public VendaId() {
	}
	
	public VendaId(Long clienteId, Long planoId) {
		this.clienteId = clienteId;
		this.planoId = planoId;
	}
	
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof VendaId) {
			VendaId that = (VendaId)obj;
			return this.clienteId.equals(that.clienteId)
					&& this.planoId.equals(that.planoId);
		}
		return false;
	}
	
	public int hashCode() {
		return clienteId.hashCode() + planoId.hashCode();
	}

}
