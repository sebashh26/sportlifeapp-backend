package com.sportlife.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlife.model.user.TypeDirectory;
import com.sportlife.repo.IGenericRepo;
import com.sportlife.repo.user.ITypeDirectoryRepo;
import com.sportlife.service.impl.CRUDImpl;
import com.sportlife.service.user.ITypeDirectoryService;
@Service
public class TypeDirectoryImpl extends CRUDImpl<TypeDirectory, String> implements ITypeDirectoryService{

	@Autowired
	private ITypeDirectoryRepo directoryRepo;
	
	@Override
	protected IGenericRepo<TypeDirectory, String> getRepo() {
		return directoryRepo;
	}
}
