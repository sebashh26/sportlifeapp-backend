package com.sportlife.service.team;

import com.sportlife.model.team.Player;
import com.sportlife.model.team.Team;
import com.sportlife.model.team.TeamPlayer;
import com.sportlife.service.ICRUD;

public interface ITeamService extends ICRUD<Team, String>  {
	
	TeamPlayer saveTeamPlayer(Team team, Player player);
}
