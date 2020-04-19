package br.home.adrnmatos.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.home.adrnmatos.domain.Cliente;
import br.home.adrnmatos.uteis.Uteis;

public class ClienteDAOImpl implements ClienteDAO {
	
	@Override
	public void makePersistent(Cliente cliente) {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		entityManager.persist(cliente);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listaClientes() {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		Query query = entityManager.createNamedQuery("Cliente.findAll");
		
		listaClientes = query.getResultList();
		
		return listaClientes;
	}
	
	@Override
	public void excluirCliente(Cliente cliente) {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		entityManager.remove(cliente);
	}
	
	@Override
	public void atualizarCliente(Cliente cliente) {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		entityManager.merge(cliente);
	}

	@Override
	public Cliente findById(Long clienteId) {
		
		EntityManager entityManager = Uteis.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("Cliente.findCliente");
		
		query.setParameter("id", clienteId);

		return (Cliente) query.getSingleResult();
	}

}
