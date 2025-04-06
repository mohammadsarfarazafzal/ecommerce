package hb.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class Users {
	
//	Users Entity:
//		o id (Primary Key, auto-generated)
//		o username (Unique, Not Null)
//		o password (Hashed, Not Null)
//		o email (Unique, Not Null)
//		o role (ADMIN, CUSTOMER)
//		o Relationship: One-to-Many with Orders
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int id;
	
	@Column(name="username", length=20, unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false, length=20)
	private String password;
	
	@Column(name="email", nullable=false, unique=true, length=20)
	private String email;
	
	// Enumeration Role, Either ADMIN or CUSTOMER
	
	public enum Role{
		ADMIN, CUSTOMER
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable=false)
	private Role role;
	
	// default constructor
	
	public Users() {
		this.id = 0;
		this.email = null;
		this.password = null;
		this.username = null;
		this.role = null;
	}
	
	// parameterized constructor

	public Users(String username, String password, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	// toString method
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
}
