package com.sportlife.controller.user;

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

import com.sportlife.dto.user.TypeDirectoryDTO;
import com.sportlife.exception.ModelNotFoundException;
import com.sportlife.model.user.TypeDirectory;
import com.sportlife.service.user.ITypeDirectoryService;

@RestController
@RequestMapping("/typedirectorys")
public class TypeDirectoryController {
	// cuando nos comuniquemos entre capa ir con la interface para se sea
	// desacoplado el codigo test
	@Autowired
	private ITypeDirectoryService iTypeDirectoryService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{id}")
	public ResponseEntity<TypeDirectoryDTO> findById(@PathVariable("id") String id) throws ModelNotFoundException {
		TypeDirectoryDTO typeDirectoryDto;
		TypeDirectory typeDirectory = iTypeDirectoryService.findById(id);
		if (typeDirectory == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			typeDirectoryDto = modelMapper.map(typeDirectory, TypeDirectoryDTO.class);
		}
		return new ResponseEntity<>(typeDirectoryDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TypeDirectoryDTO>> findAll() {
		List<TypeDirectoryDTO> typeDirectoryDTOs = this.mapList(iTypeDirectoryService.findAll(), TypeDirectoryDTO.class);
		return new ResponseEntity<>(typeDirectoryDTOs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody TypeDirectoryDTO typeDirectoryDto) {

		TypeDirectory typeDirectorySave = iTypeDirectoryService.save(modelMapper.map(typeDirectoryDto, TypeDirectory.class));
		URI uriTypeDirectoryLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(typeDirectorySave.getIdTypeDirectory()).toUri();
		return ResponseEntity.created(uriTypeDirectoryLocation).build();
		// return new ResponseEntity<>(iTypeDirectoryService.save(typeDirectory), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<TypeDirectory> update(@Valid @RequestBody TypeDirectoryDTO typeDirectoryDto) throws ModelNotFoundException {
		TypeDirectory typeDirectory = iTypeDirectoryService.findById(typeDirectoryDto.getIdTypeDirectory());
		if (typeDirectory == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + typeDirectoryDto.getIdTypeDirectory());
		}
		return new ResponseEntity<>(iTypeDirectoryService.update(modelMapper.map(typeDirectoryDto, TypeDirectory.class)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") String id) throws ModelNotFoundException {
		TypeDirectory typeDirectory = iTypeDirectoryService.findById(id);
		if (typeDirectory == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			iTypeDirectoryService.delete(id);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

}
