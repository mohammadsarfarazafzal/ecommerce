package hb.ecommerce.crud;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hb.ecommerce.entity.Category;
import hb.ecommerce.entity.OrderDetails;
import hb.ecommerce.entity.Orders;
import hb.ecommerce.entity.Product;
import hb.ecommerce.entity.Users;
import hb.ecommerce.entity.Users.Role;

public class CreateOrdersAndOrderDetails {
	SessionFactory factory = null;
	public CreateOrdersAndOrderDetails(SessionFactory factory) {
		this.factory = factory;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// create category
		Category category = new Category("Fashion", "Trending Fashion");
		
		// create product
		Product product1 = new Product("Black Hoody", 3990.99, 15, category);
		Product product2 = new Product("White Blazer", 11999.99, 19, category);
		
		// create user
		Users user = new Users("nishant", "nbhadani123", "nishant@google.com", Role.CUSTOMER);
		
		// create order
		Orders order = new Orders();
		order.setOrderDate(LocalDateTime.now());
		order.setUser(user);
		
		//create order details
		OrderDetails details1 = new OrderDetails(2, 3990.99, order, product1);
		OrderDetails details2 = new OrderDetails(1, 11999.99, order, product2);
		
		order.setTotalAmount(details1.getUnitPrice()*details1.getQuantity()+details2.getUnitPrice()*details2.getQuantity());
		
		session.persist(details1);
		session.persist(details2);
		
		// commit changes
		
		session.getTransaction().commit();
		
		// close the session
		
		session.close();
		
		// message
		
		System.out.println("Created "+order.toString());
		
	}
}
