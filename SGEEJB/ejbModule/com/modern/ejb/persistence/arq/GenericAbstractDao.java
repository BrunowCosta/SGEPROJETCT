package com.modern.ejb.persistence.arq;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public abstract class GenericAbstractDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	@PersistenceContext(unitName="SGE")
	protected EntityManager manager;
	
	private Session session;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericAbstractDao() {
		this.setEntityClass((Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	public void persist(T obj) {
		getManager().persist(obj);;
		getManager().flush();
	}

	@Override
	public void remove(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T merge(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMaxId(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMinId(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	protected EntityManager getManager() {
		return manager;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	private Class<T> getEntityClass() {
		return entityClass;
	}

	private void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
