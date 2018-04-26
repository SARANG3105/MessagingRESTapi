package org.myrest.message.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.myrest.message.model.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UserDAO {
	
	public User addUser(User usr) {
		
		Session session= SessionUtil.getSession();
		Transaction tx= session.beginTransaction();
		User user = new User();
		user.setUser_id(usr.getUser_id());
		user.setUser_email(usr.getUser_email());
		user.setUser_fname(usr.getUser_fname());
		user.setUser_lname(usr.getUser_lname());
		session.save(user);
		tx.commit();
		session.close();
		return user;
	}
	public List<User> getAllUsers(){
		Session session= SessionUtil.getSession();
		Transaction tx= session.beginTransaction();
		Query qry= session.createQuery("from User u");
		List user= qry.list();
		Iterator iter= user.iterator();
		List<User> users= new ArrayList<>();
		while(iter.hasNext()) {
			Object o= iter.next();
			User u= (User)o;
			users.add(u);
		}
		return users;
			
		}
}


