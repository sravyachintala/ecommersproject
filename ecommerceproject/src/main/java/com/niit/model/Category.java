package com.niit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CATEGORY_S191174100121")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@NotEmpty(message="CATEGORY NAME IS MANDATORY")
private String categoryname;
@OneToMany(mappedBy="category")
private List<Product> products;
public int getId() {
	return id;
}
public void setId(int id) {
	System.out.println("SETTER MEHTOD IN CATEGORY FOR THE PRODUCT ID");
	this.id = id;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}

}
