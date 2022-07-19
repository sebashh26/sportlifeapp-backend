package com.sportlife.repo.user;

import com.sportlife.model.user.User;
import com.sportlife.repo.IGenericRepo;
//no es necesario @repositury porque ya esta implicito en el extends
public interface IUserRepo extends IGenericRepo<User, Integer>{

}
