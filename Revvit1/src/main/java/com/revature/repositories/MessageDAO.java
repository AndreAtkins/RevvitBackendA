package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Message;


public class MessageDAO implements IMessageDAO{


	@Autowired
	private SessionFactory sf;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Message> findAll() {
		Session s = sf.getCurrentSession();
		return (List<Message>) s.createCriteria(Message.class).list();
	}

	@Override
	@Transactional
	public Message findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Message.class, id);
	}

	@Override
	@Transactional
	public void save(Message u) {
		Session s = sf.getCurrentSession();
		s.save(u);
	}
	
	@Override
	@Transactional
	public void update(Message u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}


}
