package hb.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")

public class Orders {
	
//	Orders Entity:
//		o id (Primary Key, auto-generated)
//		o orderDate (Timestamp, Not Null)
//		o totalAmount (Decimal, Not Null)
//		o Relationship: Many-to-One with Users, One-to-Many with OrderDetails
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderId")
	private int id;
	
	@Column(name="orderDate", nullable=false)
	private LocalDateTime orderDate;
	
	@Column(name="totalAmount", nullable=false)
	private double totalAmount;
	
	// required relationship with users, i.e. ManyToOne
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private Users user;
	
	
	// default constructor
	
	public Orders() {
		this.id = 0;
		this.orderDate = null;
		this.totalAmount = 0;
		this.user = null;
	}

	// parameterized constructor
	
	public Orders(LocalDateTime orderDate, double totalAmount, Users user) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.user = user;
	}

	// parameterized constructor
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	// toString method
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", user=" + user
				+ ", orderDetails=" + "]";
	}
	
}