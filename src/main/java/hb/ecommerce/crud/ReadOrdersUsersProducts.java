package hb.ecommerce.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hb.ecommerce.entity.OrderDetails;

public class ReadOrdersUsersProducts {
	SessionFactory factory = null;
	public ReadOrdersUsersProducts(SessionFactory factory) {
		this.factory = factory;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<OrderDetails> OrderDetailsList = session.createQuery("from OrderDetails").getResultList();
		if(OrderDetailsList.size()==0) {
			System.out.println("No record found");
			return;
		}
		else {
			for(OrderDetails element:OrderDetailsList) {
				System.out.println(element.toString());
			}
		}
		session.close();
	}
}
