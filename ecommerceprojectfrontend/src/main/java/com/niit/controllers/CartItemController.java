package com.niit.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;
import com.niit.service.CartItemService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
public class CartItemController {
	@Autowired
private CartItemService cartItemService;
	@Autowired	
private ProductService productService;
	@Autowired
private CustomerService customerService;
	@RequestMapping(value="/cart/addtocart/{id}")
	public String addToCart(@PathVariable int id, @RequestParam int requestedQuantity, @AuthenticationPrincipal Principal principal)
	{
		String email=principal.getName();
		Product product=productService.selectProducts(id);
		User user=customerService.getUser(email);
		List<CartItem> cartItems =cartItemService.getCart(email);
		for(CartItem cartItem:cartItems)
		{
			System.out.println(cartItem.getProduct().getId());
			System.out.println(id);
			if(cartItem.getProduct().getId()==id)
			{
				cartItem.setQuantity(requestedQuantity);			
				cartItem.setTotalprice(requestedQuantity*product.getPrice());
				cartItemService.addToCart(cartItem);
				return "redirect:/cart/getcart";
			}
		}
		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(requestedQuantity);
		cartItem.setUser(user);
		cartItem.setTotalprice(requestedQuantity*product.getPrice());
		cartItemService.addToCart(cartItem);
		return "redirect:/cart/getcart";
		
	}
	@RequestMapping(value="/cart/getcart")
	public String getCart(@AuthenticationPrincipal Principal principal,Model m,HttpSession session)
	{
		String email=principal.getName();
		List<CartItem> cartItems=cartItemService.getCart(email);
		m.addAttribute("cartItems", cartItems);
		session.setAttribute("cartSize", cartItems.size());
		return "cart";
	}
	@RequestMapping(value="/cart/removecartitem/{cartId}")
	public String removeCartItem(@PathVariable int cartId)
	{
		cartItemService.removeCartItem(cartId);
		return "redirect:/cart/getcart";
		
	}
	@RequestMapping(value="/cart/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal)
	{
		List<CartItem> cartItems=cartItemService.getCart(principal.getName());
		for(CartItem cartItem:cartItems)
		{
			cartItemService.removeCartItem(cartItem.getCartId());
		}
		return "redirect:/cart/getcart";
	}
	@RequestMapping(value="/cart/shippingaddressform")
	public String getShippingAddressForm(@AuthenticationPrincipal Principal principal,Model m)
	{
		String email=principal.getName();
		User user=customerService.getUser(email);
		Customer customer=user.getCustomer();
		ShippingAddress shippingAddress=customer.getShippingaddress();
		m.addAttribute("shippingaddress", shippingAddress);
		return "shippingaddress";
	}
	@RequestMapping(value="/cart/createorder")
	public String createCustomerOrder(@ModelAttribute ShippingAddress shippingaddress,Model m,@AuthenticationPrincipal Principal principal,HttpSession session)
	{
		String email=principal.getName();
		User user=customerService.getUser(email);
		List<CartItem> cartItems=cartItemService.getCart(email);
		Customer customer=user.getCustomer();
		customer.setShippingaddress(shippingaddress);
		user.setCustomer(customer);
		customer.setUser(user);
		double grandTotal=0.0;
		for(CartItem cartItem:cartItems)
		{
			grandTotal=grandTotal+cartItem.getTotalprice();
		}
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		customerOrder.setGrandTotal(grandTotal);
		customerOrder.setUser(user);
		if(cartItems.size()>0)
		{
			cartItemService.createCustomerOrder(customerOrder);
		}
		for(CartItem cartItem:cartItems)
		{
			Product p=cartItem.getProduct();
			p.setQuantity(p.getQuantity()-cartItem.getQuantity());
			productService.updateProducts(p);
			cartItemService.removeCartItem(cartItem.getCartId());
		}
		session.setAttribute("cartSize", 0);
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("customerOrder", customerOrder);
		return "orderDetails";
	}
}
