package com.niit.service;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;

public interface CartItemService {
public void addToCart(CartItem cartItem);

public void deleteFromCart(int id);

public List<CartItem> getCart(String email);

public void removeCartItem(int id);

public void createCustomerOrder(CustomerOrder customerOrder);
}
