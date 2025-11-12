package com.ecommerce.Ecommerce.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products") 
public class Products {
	@Id
	private int id;
	private String name;
	private double price;
	private String description;
	private String image_url;
	private String category;
	private int stock;
	
	
	public Products() {
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", image_url=" + image_url + ", category=" + category + ", stock=" + stock + "]";
	}
	public Products(int id, String name, double price, String description, String image_url, String category,
			int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image_url = image_url;
		this.category = category;
		this.stock = stock;
	}


	
	


}
