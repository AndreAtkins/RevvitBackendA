package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Revvit;
import com.revature.models.User;
import com.revature.repositories.IRevvitDAO;
import com.revature.repositories.IUserDAO;

public class Driver {

	
	
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUserDAO dao = (IUserDAO) ac.getBean("userDAO");
		
		IRevvitDAO rdao = (IRevvitDAO) ac.getBean("revvitDAO");
		
		
		User user1 = new User(0, "Larry", "King", "larryking","lking@gmail.com","basketball13");
		
		User user2 = new User(0, "Sue", "Queen", "suequeen","suequeen@gmail.com","basketball13");
		
		
		
		
		System.out.println(user1);
		
		//dao.save(user2);
		
		dao.save(user1);
		
		
		List<User> list = new ArrayList<User>();
		
		
		list.add(user1);
		list.add(user2);
		
		
		Revvit rev = new Revvit(0, user1, "hello world", null, null, null);
		
		Revvit rev2 = new Revvit(0, user2, "wassup world", null, null, null);
		
		rev2.setLikes(list);
		
		rdao.save(rev);
		
		rdao.save(rev2);
		
		
		list.remove(user2);
		
		user2.setFollowers(list);
		
		dao.save(user2);
		
		System.out.println(user2);
		
		System.out.println(rev);
		
		
		System.out.println(user2);
		//dao.save(new User(0, "Harry", "Potter"));
		
//		User u = dao.findById(1);
//		User u2 = dao.findById(2);
//		System.out.println(u);
//		System.out.println(u2);
//		System.out.println(u.addFriend(u2));
//		dao.update(u);

//		System.out.println(dao.findAll());
	}	
	
	
}
