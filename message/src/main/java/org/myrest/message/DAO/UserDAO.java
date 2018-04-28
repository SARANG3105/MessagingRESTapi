package org.myrest.message.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.myrest.message.model.Login;
import org.myrest.message.model.Token;
import org.myrest.message.model.User;
import java.util.ArrayList;
import java.util.Iterator;


public class UserDAO {

	public User  addUser(User usr, String hashedPass){
		List<User> users= validateUser(usr);
		if(users.size()>0) {
			System.out.println("hala");
			return null;
		}else {
			Session session= SessionUtil.getSession();
			Transaction tx= session.beginTransaction();
			User user = new User();
			user.setUser_id(usr.getUser_id());
			user.setUser_email(usr.getUser_email());
			user.setUser_fname(usr.getUser_fname());
			user.setUser_lname(usr.getUser_lname());
			user.setPassword(hashedPass);
			session.save(user);
			tx.commit();
			session.close();
			usr.setUser_id(user.getUser_id());
			return getToken(usr);
		}
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

	public User getToken(User user) {
		String token=Token.getToken(user.getUser_fname(), user.getUser_lname(), user.getUser_id());
		user.setToken(token);
		return user;
	}

	public List<User> validateUser(User user) {
		Session session= SessionUtil.getSession();
		Query qry= session.createQuery("from User where user_email=:user_email");

		qry.setString("user_email", user.getUser_email());
		List<User> usr= qry.list();
		session.close();
		return usr;
	}

	public User validateLogin(Login user) {
		Session session= SessionUtil.getSession();
		Query qry= session.createQuery("from User where user_email=:email");
		qry.setString("email", user.getEmail());
		List<User> usr= qry.list();
		session.close();
		return usr.get(0);
	}
}


