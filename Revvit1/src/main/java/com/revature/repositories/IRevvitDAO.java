package com.revature.repositories;

import java.util.List;

import com.revature.models.Revvit;
import com.revature.models.User;

public interface IRevvitDAO {
	
	
	

	public List<Revvit> findAll();
	public Revvit findById(int id);
	public void save(Revvit rev);
	public void update(Revvit rev);

}
