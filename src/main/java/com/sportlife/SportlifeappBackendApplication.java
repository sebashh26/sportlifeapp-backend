package com.sportlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sportlife.model.user.User;
import com.sportlife.model.user.drop.UserDirectory;
import com.sportlife.model.user.drop.UserDirectoryPK;	

@SpringBootApplication
public class SportlifeappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportlifeappBackendApplication.class, args);
		UserDirectory directory = new UserDirectory();
		directory.setUserDirectoryPK(new UserDirectoryPK());
		directory.getUserDirectoryPK().setIdTypeDirectory("a");
		directory.getUserDirectoryPK().setIdUser(1);
		directory.setDescription("a");
		UserDirectory directory1 = new UserDirectory();
		directory1.setUserDirectoryPK(new UserDirectoryPK());
		directory1.getUserDirectoryPK().setIdTypeDirectory("a");
		directory1.getUserDirectoryPK().setIdUser(1);
		directory1.setDescription("n");
		System.out.println(directory.equals(directory1));
		User user = new User();
		user.setIdUser(1);
		user.setIdCountryCurrent("c");
		User user2 = new User();
		user2.setIdUser(1);
		user.setIdCountryCurrent("d");
		System.out.println(user.equals(user2));
		
	}

}
