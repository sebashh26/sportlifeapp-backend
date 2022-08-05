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

import com.sportlife.dto.team.TeamDTO;
import com.sportlife.dto.team.TeamPlayerDTO;
import com.sportlife.exception.ModelNotFoundException;
import com.sportlife.model.team.Player;
import com.sportlife.model.team.Team;
import com.sportlife.service.team.ITeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private ITeamService iTeamService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{id}")
	//@Transactional
	public ResponseEntity<TeamDTO> findById(@PathVariable("id") String id) throws ModelNotFoundException {
		TeamDTO teamDto;
		
		Team team = iTeamService.findById(id);
		if (team == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
//			TypeMap<Team, TeamDTO> propertyMapper = modelMapper.createTypeMap(Team.class, TeamDTO.class);
//		    propertyMapper.addMappings(mapper -> mapper.skip(TeamDTO::setTeamPlayers));
			teamDto = modelMapper.map(team, TeamDTO.class);
		}
		return new ResponseEntity<>(teamDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TeamDTO>> findAll() {
		List<TeamDTO> userDTOs = this.mapList(iTeamService.findAll(), TeamDTO.class);
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody TeamDTO teamDto) throws ModelNotFoundException {
		Team teamSave = iTeamService.save(modelMapper.map(teamDto, Team.class));
		URI uriTeamLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(teamSave.getIdTeam()).toUri();
		return ResponseEntity.created(uriTeamLocation).build();
	}

	@PostMapping("/teamplayer")
	public ResponseEntity<TeamPlayerDTO> saveTeamPlayer(@Valid @RequestBody TeamPlayerDTO teamPlayerDTO)
			throws ModelNotFoundException {
		Team team = modelMapper.map(teamPlayerDTO.getTeamDTO(), Team.class);
		Player player = modelMapper.map(teamPlayerDTO.getPlayerDTO(), Player.class);		
		iTeamService.saveTeamPlayer(team, player);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Team> update(@Valid @RequestBody TeamDTO teamDto) throws ModelNotFoundException {
		Team team = iTeamService.findById(teamDto.getIdTeam());
		if (team == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + teamDto.getIdTeam());
		}
		return new ResponseEntity<>(iTeamService.update(modelMapper.map(teamDto, Team.class)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") String id) throws ModelNotFoundException {
		Team team = iTeamService.findById(id);
		if (team == null) {
			throw new ModelNotFoundException("ID NOT FOUND EXCEPTION: " + id);
		} else {
			iTeamService.delete(id);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

}
