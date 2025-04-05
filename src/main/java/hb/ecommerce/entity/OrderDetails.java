package hb.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderdetails")

public class OrderDetails {
	
//	OrderDetails Entity:
//		o id (Primary Key, auto-generated)
//		o quantity (Integer, Not Null)
//		o unitPrice (Decimal, Not Null)
//		o Relationship: Many-to-One with Orders, Many-to-One with Product
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="detailsId")
	private int id;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	@Column(name="unitPrice", nullable=false)
	private double unitPrice;
	
	// required relationship with users, i.e. ManyToOne
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Users user;
	
	// required relationship with product, i.e. ManyToOne
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	// Default constructor
	
    public OrderDetails() {
        this.id = 0;
        this.quantity = 0;
        this.unitPrice = 0;
        this.user = null;
        this.product = null;
    }

	// parameterized constructor
    
	public OrderDetails(int quantity, double unitPrice, Users user, Product product) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.user = user;
		this.product = product;
	}

	// getter setter methods
	
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	// toString method
	
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", user=" + user
				+ ", product=" + product + "]";
	}
	
}
