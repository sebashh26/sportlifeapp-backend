package com.sportlife.user.repo;

import com.sportlife.repo.IGenericRepo;
import com.sportlife.user.model.User;
//no es necesario @repositury porque ya esta implicito en el extends
public interface IUserRepo extends IGenericRepo<User, Integer>{

}
