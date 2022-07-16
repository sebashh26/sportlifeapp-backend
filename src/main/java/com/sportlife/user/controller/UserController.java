package com.sportlife.user.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.sportlife.exception.ModelNotFoundException;
import com.sportlife.user.dto.UserDTO;
import com.sportlife.user.model.User;
import com.sportlife.user.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	// cuando nos comuniquemos entre capa ir con la interface para se sea
	// desacoplado el codigo test
	@Autowired
	private IUserService iUserService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		UserDTO userDto;
		User user = iUserService.findById(id);
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			userDto = modelMapper.map(user, UserDTO.class);
		}
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> userDTOs = this.mapList(iUserService.findAll(), UserDTO.class);
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody UserDTO userDto) {

		User userSave = iUserService.save(modelMapper.map(userDto, User.class));
		URI uriUserLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userSave.getIdUser()).toUri();
		return ResponseEntity.created(uriUserLocation).build();
		// return new ResponseEntity<>(iUserService.save(user), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<User> update(@Valid @RequestBody UserDTO userDto) throws ModelNotFoundException {
		User user = iUserService.findById(userDto.getIdUser());
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + userDto.getIdUser());
		}
		return new ResponseEntity<>(iUserService.update(modelMapper.map(userDto, User.class)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		User user = iUserService.findById(id);
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			iUserService.delete(id);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

}
