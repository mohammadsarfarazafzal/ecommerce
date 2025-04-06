package hb.ecommerce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.ecommerce.crud.CreateOrdersAndOrderDetails;
import hb.ecommerce.crud.CreateProductAndCategory;
import hb.ecommerce.crud.CreateUsers;
import hb.ecommerce.crud.ReadOrdersUsersProducts;
import hb.ecommerce.entity.*;

public class App {
    public static void main(String[] args) {
    	
        // Load configuration and create session factory
    	
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetails.class)
                .buildSessionFactory();

        // Open session to force table creation, Hibernate will trigger schema update
        
//        Session session = factory.openSession();
//        session.close();
//
//        factory.close();
//
//        System.out.println("Hibernate setup complete.");
    	
    	
    	// create product and category
    	
    	//new CreateProductAndCategory(factory);
    	
    	// create users
    	
    	//new CreateUsers(factory);
        
        // create orders
        
        // new CreateOrdersAndOrderDetails(factory);
        
        // fetch details
        
        new ReadOrdersUsersProducts(factory);
        
        factory.close();
    }
}