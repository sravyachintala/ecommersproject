package com.niit.daoimplementations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CustomerDao;
import com.niit.model.Authorities;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.User;
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sf;
	public void registerCustomer(Customer customer)
	{
		Session s=sf.getCurrentSession();
		//MAKE USER PROPERTY IN AUTHORITIES CLASS TO REFER USER OBJECT
		User user=customer.getUser();
		Authorities authorities=user.getAuthorities();
		authorities.setUser(user);
		s.save(customer);
	}
	@Override
	public boolean isEmailUnique(String email) {
		Session s=sf.getCurrentSession();
		User user=(User)s.get(User.class, email);//select * from user where email='james.s@niit.com'
		if(user==null)//entered email is unique
			return true;
		else //entered email already exists in the table
			return false;
	}
	@Override
	public User getUser(String email) {
		Session s=sf.getCurrentSession();
		User u=(User)s.get(User.class, email);
		return u;
	}
}
