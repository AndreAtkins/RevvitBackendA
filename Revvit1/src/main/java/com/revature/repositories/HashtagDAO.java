package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Hashtags;

public class HashtagDAO implements IHashtagDAO {

	@Autowired
	private SessionFactory sf;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Hashtags> findAll() {
		Session s = sf.getCurrentSession();
		return (List<Hashtags>) s.createCriteria(Hashtags.class).list();
	}

	@Override
	@Transactional
	public Hashtags findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Hashtags.class, id);
	}

	@Override
	@Transactional
	public void save(Hashtags u) {
		Session s = sf.getCurrentSession();
		s.save(u);
	}
	
	@Override
	@Transactional
	public void update(Hashtags u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}
	
	
}
