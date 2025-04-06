package hb.ecommerce.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hb.ecommerce.entity.Users;
import hb.ecommerce.entity.Users.Role;

public class CreateUsers {
	SessionFactory factory = null;
	public CreateUsers(SessionFactory factory) {
		this.factory = factory;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// create users - ADMIN
		
		Users user = new Users("sarfaraz", "strongPassword123", "sarfaraz@google.com", Role.ADMIN);
		
		session.persist(user);
		
		// create users - CUSTOMER
		
		user = new Users("atif", "strongerPassword123", "atif@google.com", Role.CUSTOMER);
		
		session.persist(user);
		
		// commit changes
		
		session.getTransaction().commit();
		
		// close the session
		
		session.close();
		
		// message
		
		System.out.println("Created "+user.toString());
	}
}
