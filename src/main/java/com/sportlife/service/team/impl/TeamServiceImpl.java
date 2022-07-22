package com.sportlife.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlife.model.team.Team;
import com.sportlife.repo.IGenericRepo;
import com.sportlife.repo.team.ITeamRepo;
import com.sportlife.service.impl.CRUDImpl;
import com.sportlife.service.team.ITeamService;
@Service
public class TeamServiceImpl extends CRUDImpl<Team, String> implements ITeamService{

	@Autowired
	private ITeamRepo iTeamRepo;
	
	@Override
	protected IGenericRepo<Team, String> getRepo() {
		return iTeamRepo	;
	}
}
