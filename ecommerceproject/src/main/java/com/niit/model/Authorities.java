package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Authorities_S191174100121")
public class Authorities {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String role;
@OneToOne
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
