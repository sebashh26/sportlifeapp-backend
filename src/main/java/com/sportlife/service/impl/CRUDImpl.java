package com.sportlife.service.impl;

import java.util.List;

import com.sportlife.repo.IGenericRepo;
import com.sportlife.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID> {
	
	
	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T save(T t) {
		return getRepo().save(t);
	}

	@Override
	public T update(T t) {
		return getRepo().save(t);
	}

	@Override
	public T findById(ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public List<T> findAll() {
		return getRepo().findAll();
	}

	@Override
	public void delete(ID id) {
		getRepo().deleteById(id);
	}

}
