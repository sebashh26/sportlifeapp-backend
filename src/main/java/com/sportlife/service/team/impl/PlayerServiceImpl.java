package com.sportlife.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportlife.model.team.Player;
import com.sportlife.repo.IGenericRepo;
import com.sportlife.repo.team.IPlayerRepo;
import com.sportlife.service.impl.CRUDImpl;
import com.sportlife.service.team.IPlayerService;
@Service
public class PlayerServiceImpl extends CRUDImpl<Player, Integer> implements IPlayerService{

	@Autowired
	private IPlayerRepo iPlayerRepo;
	
	@Override
	protected IGenericRepo<Player, Integer> getRepo() {
		return iPlayerRepo;
	}
}
