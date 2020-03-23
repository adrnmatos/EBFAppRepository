package br.home.adrnmatos.persistence;

import java.util.List;

import javax.persistence.LockModeType;

public interface GenericDAO<T, ID> {
	
	public T findById(ID id);
	public T findById(ID id, LockModeType lock);
	public T findReferenceById(ID id);
	public List<T> findAll();
	public Long getCount();
	public T makePersistent(T entity);
	public void makeTransient(T entity);
	public void checkVersion(T entity, boolean forceUpdate);

}
