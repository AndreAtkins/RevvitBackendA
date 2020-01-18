package com.revature.repositories;

import java.util.List;


import com.revature.models.Hashtags;

public interface IHashtagDAO {


	public List<Hashtags> findAll();
	public Hashtags findById(int id);
	public void save(Hashtags ht);
	public void update(Hashtags ht);
	
	
	
}
