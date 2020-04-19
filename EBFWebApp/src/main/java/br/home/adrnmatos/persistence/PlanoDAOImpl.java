package br.home.adrnmatos.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.home.adrnmatos.domain.Plano;
import br.home.adrnmatos.uteis.Uteis;

public class PlanoDAOImpl implements PlanoDAO {

	@Override
	public void makePersistent(Plano plano) {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		entityManager.persist(plano);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plano> getPlanos() {

		List<Plano> planos = new ArrayList<Plano>();
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("Plano.findAll");
		
		planos = query.getResultList();
		
		return planos;
	}

	@Override
	public Plano findById(Long userId) {

		EntityManager entityManager = Uteis.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("Plano.findPlano");
		
		query.setParameter("id", userId);

		return (Plano) query.getSingleResult();
	}

}
