package com.ecommerce.Ecommerce.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "allusers")   // must match DB table
public class Users {

    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String addresses;
    public enum Role {
        CUSTOMER, ADMIN
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
//	public Users(int id, String username, String password, String email, String addresses) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.addresses = addresses;
//	}
//	@Override
//	public String toString() {
//		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
//				+ ", addresses=" + addresses + "]";
//	}

    
    
    
    
    
//    
//    private int id;
//    private String username;
//	private String password;
	
//    public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}


    // getters & setters
}