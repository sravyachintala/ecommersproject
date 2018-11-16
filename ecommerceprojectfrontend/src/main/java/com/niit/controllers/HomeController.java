package com.niit.controllers;



import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.CartItem;
import com.niit.service.CartItemService;


@Controller
public class HomeController 
{
	@Autowired
	private CartItemService cartItemService;
	public HomeController() {
		System.out.println("Home Controller Bean has been created");
	}
	@RequestMapping(value="/home")
	public String getHomePage(Model m,@AuthenticationPrincipal Principal principal,HttpSession session)
	{
		if(principal!=null)
		{
			String email=principal.getName();
			List<CartItem> cartItems=cartItemService.getCart(email);
			session.setAttribute("cartSize", cartItems.size());
		}
		return "home";
	}
	@RequestMapping(value="/login")
	public String loginPage(Model m)
	{
		
		return "loginpage";
	}
	@RequestMapping(value="/loginerror")
	public String loginErrorPage(Model m)
	{
		m.addAttribute("loginError", "INVALID EMAIL ADDRESS OR PASSWORD...................");
		return "loginpage";
	}
	@RequestMapping(value="/log-out")
	public String loginoutPage(Model m)
	{
		m.addAttribute("message", "LOGGED-OUT SUCCESSFULLY...................");
		return "loginpage";
	}
}
