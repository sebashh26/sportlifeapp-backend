package com.sportlife.repo.user;

import com.sportlife.model.user.TypeDirectory;
import com.sportlife.repo.IGenericRepo;
//no es necesario @repositury porque ya esta implicito en el extends
public interface ITypeDirectoryRepo extends IGenericRepo<TypeDirectory, String>{

}
