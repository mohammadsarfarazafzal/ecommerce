package hb.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")

public class Category {
	
	//  Category Entity:
	//  	o id (Primary Key, auto-generated)
	//  	o name (Unique, Not Null)
	//  	o description
	//  	o Relationship: One-to-Many with Product
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId")
	private int id;
	
	@Column(name="categoryName", unique=true, length=20, nullable=false)
	private String name;
	
	@Column(name="categoryDescription", length=50)
	private String description;
	
	// default constructor
	
	public Category() {
		this.id = 0;
		this.name = null;
		this.description = null;
	}

	// parameterized constructor
	
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	// toString method
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
