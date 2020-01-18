package com.revature.repositories;

import java.util.List;

import com.revature.models.Message;

public interface IMessageDAO {

	
	public List<Message> findAll();
	public Message findById(int id);
	public void save(Message u);
	public void update(Message u);
}
