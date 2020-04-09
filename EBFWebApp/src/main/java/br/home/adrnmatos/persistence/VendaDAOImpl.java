package br.home.adrnmatos.persistence;

import javax.persistence.EntityManager;

import br.home.adrnmatos.domain.Venda;
import br.home.adrnmatos.uteis.Uteis;

public class VendaDAOImpl implements VendaDAO {

	@Override
	public void makePersistent(Venda venda) {

		EntityManager entityManager = Uteis.jpaEntityManager();
		entityManager.persist(venda);
	}

}
