package br.home.adrnmatos.persistence;

import javax.persistence.EntityManager;

import br.home.adrnmatos.model.Plano;
import br.home.adrnmatos.uteis.Uteis;

public class PlanoDAOImpl implements PlanoDAO {

	@Override
	public void makePersistent(Plano plano) {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		entityManager.persist(plano);
	}

}
