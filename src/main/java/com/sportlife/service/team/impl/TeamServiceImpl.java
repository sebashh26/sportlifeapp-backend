package com.sportlife.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlife.Enum.EnumStatus;
import com.sportlife.model.team.Player;
import com.sportlife.model.team.Team;
import com.sportlife.model.team.TeamPlayer;
import com.sportlife.model.team.TeamPlayerPK;
import com.sportlife.repo.IGenericRepo;
import com.sportlife.repo.team.ITeamPlayerRepo;
import com.sportlife.repo.team.ITeamRepo;
import com.sportlife.service.impl.CRUDImpl;
import com.sportlife.service.team.ITeamService;
@Service
public class TeamServiceImpl extends CRUDImpl<Team, String> implements ITeamService{

	@Autowired
	private ITeamRepo iTeamRepo;
	@Autowired
	private ITeamPlayerRepo iTeamPlayerRepo;
	
	@Override
	protected IGenericRepo<Team, String> getRepo() {
		return iTeamRepo	;
	}

	@Override
	public TeamPlayer saveTeamPlayer(Team team, Player player) {
		TeamPlayer teamPlayer =  new TeamPlayer(new TeamPlayerPK(player.getIdUser(), team.getIdTeam()));
		teamPlayer.setPlayer(player);
		teamPlayer.setTeam(team);
		teamPlayer.setStatus(EnumStatus.ACT);		
		return iTeamPlayerRepo.save(teamPlayer);
		
	}
}
