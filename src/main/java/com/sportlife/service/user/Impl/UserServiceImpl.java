package com.sportlife.service.user.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlife.model.user.User;
import com.sportlife.repo.IGenericRepo;
import com.sportlife.repo.user.IUserRepo;
import com.sportlife.service.impl.CRUDImpl;
import com.sportlife.service.user.IUserService;
@Service
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService{

	@Autowired
	private IUserRepo iUserRepo;
	
	@Override
	protected IGenericRepo<User, Integer> getRepo() {
		return iUserRepo;
	}
	
	@Override
	public User save(User t) {
		t.setLastLogin(LocalDate.now());
		t.setCreatedAt(LocalDate.now());
		return getRepo().save(t);
	}
//
//	@Override
//	public User update(User t) {
//		return iUserRepo.save(t);
//	}
//	//optinoal te prepara para posibles respuetas nulas
//	@Override
//	public User findById(Integer id) {
//		Optional<User> op = iUserRepo.findById(id);
//		return op.orElseGet(User :: new);
//	}
//
//	@Override
//	public List<User> findAll() {
//		return iUserRepo.findAll();
//	}
//
//	@Override
//	public void delete(Integer id) {
//		iUserRepo.deleteById(id);
//	}

	

}
