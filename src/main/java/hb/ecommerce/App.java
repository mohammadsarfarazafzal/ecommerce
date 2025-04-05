package hb.ecommerce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hb.ecommerce.entity.Category;
import hb.ecommerce.entity.OrderDetails;
import hb.ecommerce.entity.Orders;
import hb.ecommerce.entity.Product;
import hb.ecommerce.entity.Users;

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
        
        Session session = factory.openSession();
        session.close();

        factory.close();

        System.out.println("Hibernate setup complete.");
    }
}