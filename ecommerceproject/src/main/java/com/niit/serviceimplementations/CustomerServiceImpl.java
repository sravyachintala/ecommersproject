package com.niit.serviceimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CustomerDao;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.User;
import com.niit.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	public void registerCustomer(Customer customer)
	{
		customerDao.registerCustomer(customer);
	}
	@Override
	public boolean isEmailUnique(String email) {
		
		return customerDao.isEmailUnique(email);
	}
	@Override
	public User getUser(String email) {
		
		return customerDao.getUser(email);
	}
}
