package br.home.adrnmatos.business;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.home.adrnmatos.model.Plano;
import br.home.adrnmatos.persistence.PlanoDAO;

@Named(value = "planoController")
@RequestScoped
public class PlanoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Plano plano;

	@Inject
	private PlanoDAO planoDAO;
	
	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public void salvarPlano() {
		
		plano.setCalendarioId(2L);
		
		planoDAO.makePersistent(plano);
	}


}
