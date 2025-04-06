package hb.ecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")

public class Product {
	
//	Product Entity:
//		o id (Primary Key, auto-generated)
//		o name (Not Null)
//		o price (Decimal, Not Null)
//		o stockQuantity (Integer)
//		o Relationship: Many-to-One with Category
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private int id;
	
	@Column(name="productName", nullable=false, length=20)
	private String name;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="stockQuantity")
	private int stockQuantity;
	
	// required relationship with category, i.e. ManyToOne
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private Category category;
	
	// default constructor
	
	public Product() {
		this.id = 0;
		this.name = null;
		this.price = 0;
		this.stockQuantity = 0;
		this.category = null;
	}
	
	// parameterized constructor

	public Product(String name, double price, int stockQuantity, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.category = category;
	}

	// getter and setter methods
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stockQuantity
	 */
	public int getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	// toString method
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity
				+ ", category=" + category + "]";
	}
	
}
