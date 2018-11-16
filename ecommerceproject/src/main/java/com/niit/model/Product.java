package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT_S191174100121")
public class Product
{
	

@Id  // - property id unique and not null
	
@GeneratedValue(strategy=GenerationType.AUTO) //auto generation - automatically generate the value for id
private int id;
@NotEmpty(message="PRODUCT NAME IS MANDATORY")
private String productname;
@NotEmpty(message="PRODUCT DESCRIPTION IS MANDATORY")
private String productdesc;
/*@NotNull(message="PRODUCT QUANTITY IS MANDATORY")*/
@Min(value=0,message="VALUE OF QUANTITY SHOULD BE LESSTHAN ZERO")
private int quantity;
@Min(value=1,message="MINIMUM PRICE MUST BE 1 RUPEE")
private double price;
@ManyToOne
private Category category;
 @Transient
 private MultipartFile image;

public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	System.out.println("IMAGE VALUE HAS BEEN SETTED");
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getProductdesc() {
	return productdesc;
}
public void setProductdesc(String productdesc) {
	this.productdesc = productdesc;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
