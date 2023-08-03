package com.inetum.appliSpringWeb.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inetum.appliSpringWeb.converter.GenericConverter;


public abstract class AbstractGenericService<E,ID,DTO> implements GenericService<E,ID,DTO> {

	
	public abstract CrudRepository<E,ID> getDao();
	public abstract Class<DTO> getDaoClass();
	
	@Override
	public E searchById(ID id) {
		return getDao().findById(id).orElse(null);
	}

	@Override
	public DTO searchDtoById(ID id) {
		return GenericConverter.map(this.searchById(id), getDaoClass()); // ex:  getDaoClass() = CompteDto
	}
	
	@Override
	public E saveOrUpdate(E entity) {		
		return getDao().save(entity);
	}

	@Override
	public void deleteById(ID id) {
		getDao().deleteById(id);
	}

	@Override
	public boolean exsistById(ID id) {
		return getDao().existsById(id);
	}

	@Override
	public List<E> searchAll() {
		return (List<E>) getDao().findAll();
	}

	@Override
	public List<DTO> searchAllDto() {
		return GenericConverter.map(this.searchAll(), getDaoClass()); 
	} 

}
