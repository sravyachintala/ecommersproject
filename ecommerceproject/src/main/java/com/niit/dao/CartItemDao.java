package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;

public interface CartItemDao {

	public void addToCart(CartItem cartItem);

	public void deleteFromCart(int id);

	public List<CartItem> getCart(String email);

	void removeCartItem(int cartItemId);

	public void createCustomerOrder(CustomerOrder customerOrder);

}
