package com.sportlife.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportlife.user.model.User;
import com.sportlife.user.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	//cuando nos comuniquemos entre capa ir con la interface para se sea desacoplado el codigo
	@Autowired
	private IUserService iUserService;

	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Integer id) {
		return iUserService.findById(id);
	}

	@GetMapping
	public List<User> findAll() {
		return iUserService.findAll();
	}

	@PostMapping
	public User save(@RequestBody User user) {
		return iUserService.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return iUserService.update(user);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		iUserService.delete(id);
	}

}
