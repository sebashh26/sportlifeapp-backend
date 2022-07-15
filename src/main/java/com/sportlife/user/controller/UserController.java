package com.sportlife.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sportlife.user.model.User;
import com.sportlife.user.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	//cuando nos comuniquemos entre capa ir con la interface para se sea desacoplado el codigo test
	@Autowired
	private IUserService iUserService;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(iUserService.findById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users= iUserService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody User user) {
		User userSave= iUserService.save(user);
		URI uriUserLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSave.getIdUser()).toUri();
		return ResponseEntity.created(uriUserLocation).build();
		//return new ResponseEntity<>(iUserService.save(user), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		return new ResponseEntity<>(iUserService.update(user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
		iUserService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
