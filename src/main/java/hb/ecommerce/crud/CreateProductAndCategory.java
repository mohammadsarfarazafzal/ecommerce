package hb.ecommerce.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hb.ecommerce.entity.Category;
import hb.ecommerce.entity.Product;

public class CreateProductAndCategory {
	SessionFactory factory = null;
	public CreateProductAndCategory(SessionFactory factory) {
		this.factory = factory;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// create category and product - PlayStation 5
		
		Category category = new Category("Gaming","Gaming on Top");
		Product product = new Product("PlayStation 5", 49999.99, 10, category);
		session.persist(product);
		
		// create new product with old category - PlayStation 4
				
		product = new Product("PlayStation 4", 29999.99, 20, category);
		session.persist(product);
				
		// create new product with new category
				
		category = new Category("Productivity","Productivity on Peak");
		product = new Product("Asus Vivobook 16", 69999.99, 35, category);
		session.persist(product);
				
		// commit changes
		
		session.getTransaction().commit();
		
		// close the session
		
		session.close();
		
		// message
		
		System.out.println("Created "+product.toString());
		
	}
}
