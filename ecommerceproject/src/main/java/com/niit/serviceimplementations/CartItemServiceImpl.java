package com.niit.serviceimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
import com.niit.service.CartItemService;
@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{
 @Autowired
	private CartItemDao cartItemDao;
	public void addToCart(CartItem cartItem) {
		cartItemDao.addToCart(cartItem);
		
	}
	@Override
	public void deleteFromCart(int id) {
		cartItemDao.deleteFromCart(id);
		
	}
	@Override
	public List<CartItem> getCart(String email) {
		
		return cartItemDao.getCart(email);
	}
	@Override
	public void removeCartItem(int id) {
		cartItemDao.removeCartItem(id);
	}
	@Override
	public void createCustomerOrder(CustomerOrder customerOrder) {
		cartItemDao.createCustomerOrder(customerOrder);
	}

}
