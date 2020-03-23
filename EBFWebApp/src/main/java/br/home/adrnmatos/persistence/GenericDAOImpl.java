package br.home.adrnmatos.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaQuery;

import br.home.adrnmatos.uteis.Uteis;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	protected EntityManager em;
	
	protected final Class<T> entityClass;
	
	protected GenericDAOImpl(Class<T> entityClass) {
		
		this.entityClass = entityClass;		
		em = Uteis.jpaEntityManager();
	}

	@Override
	public T findById(ID id) {
		return findById(id, LockModeType.NONE);
	}

	@Override
	public T findById(ID id, LockModeType lock) {
		return em.find(entityClass, id, lock);
	}

	@Override
	public T findReferenceById(ID id) {
		return em.getReference(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(entityClass);
		c.select(c.from(entityClass));
		return em.createQuery(c).getResultList();
	}

	@Override
	public Long getCount() {
		CriteriaQuery<Long> c = em.getCriteriaBuilder().createQuery(Long.class);
		c.select(em.getCriteriaBuilder().count(c.from(entityClass)));
		return em.createQuery(c).getSingleResult();
	}

	@Override
	public T makePersistent(T entity) {
		return em.merge(entity);
	}

	@Override
	public void makeTransient(T entity) {
		em.remove(entity);
	}

	@Override
	public void checkVersion(T entity, boolean forceUpdate) {
		em.lock(entity, forceUpdate ? LockModeType.OPTIMISTIC_FORCE_INCREMENT : LockModeType.OPTIMISTIC);
	}

}
