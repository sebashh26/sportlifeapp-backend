package com.sportlife.controller.team;

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

import com.sportlife.dto.player.PlayerDTO;
import com.sportlife.exception.ModelNotFoundException;
import com.sportlife.model.team.Player;
import com.sportlife.model.user.User;
import com.sportlife.service.team.IPlayerService;
import com.sportlife.service.user.IUserService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private IPlayerService iPlayerService;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IUserService iUserService;

	@GetMapping("/{id}")
	public ResponseEntity<PlayerDTO> findById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		PlayerDTO playerDto;
		Player user = iPlayerService.findById(id);
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			playerDto = modelMapper.map(user, PlayerDTO.class);
		}
		return new ResponseEntity<>(playerDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PlayerDTO>> findAll() {
		List<PlayerDTO> userDTOs = this.mapList(iPlayerService.findAll(), PlayerDTO.class);
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody PlayerDTO playerDto) throws ModelNotFoundException {
		User user = iUserService.findById(playerDto.getIdUser());
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + playerDto.getIdUser());
		}
		Player playerSave = iPlayerService.save(modelMapper.map(playerDto, Player.class));
		URI uriPlayerLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(playerSave.getIdUser()).toUri();
		return ResponseEntity.created(uriPlayerLocation).build();
	}

	@PutMapping
	public ResponseEntity<Player> update(@Valid @RequestBody PlayerDTO playerDto) throws ModelNotFoundException {
		Player user = iPlayerService.findById(playerDto.getIdUser());
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + playerDto.getIdUser());
		}
		return new ResponseEntity<>(iPlayerService.update(modelMapper.map(playerDto, Player.class)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws ModelNotFoundException {
		Player user = iPlayerService.findById(id);
		if (user == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			iPlayerService.delete(id);
			//iPlayerService.flush();
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

}
