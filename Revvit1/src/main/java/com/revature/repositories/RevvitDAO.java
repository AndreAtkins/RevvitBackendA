package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Revvit;


@Repository
public class RevvitDAO implements IRevvitDAO {

	
	
	@Autowired
	private SessionFactory sf;
	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Revvit> findAll() {
		Session s = sf.getCurrentSession();
		return (List<Revvit>) s.createCriteria(Revvit.class).list();
	}

	@Override
	@Transactional
	public Revvit findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Revvit.class, id);
	}

	@Override
	@Transactional
	public void save(Revvit rev) {
		Session s = sf.getCurrentSession();
		s.save(rev);
	}
	
	@Override
	@Transactional
	public void update(Revvit rev) {
		Session s = sf.getCurrentSession();
		s.update(rev);
	}
}
