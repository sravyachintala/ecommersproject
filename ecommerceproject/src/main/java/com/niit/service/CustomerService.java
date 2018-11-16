package com.niit.service;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.User;

public interface CustomerService {
	public void registerCustomer(Customer customer) ;

	public boolean isEmailUnique(String email);
	public User getUser(String email);
}
