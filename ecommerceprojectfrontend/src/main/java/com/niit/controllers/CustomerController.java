package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.configuration.H2Configuration;
import com.niit.daoimplementations.CustomerDaoImpl;
import com.niit.model.Customer;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;
import com.niit.serviceimplementations.CustomerServiceImpl;


@Controller
public class CustomerController {
@Autowired
private CustomerService cs;
/*ApplicationContext ac = new AnnotationConfigApplicationContext(H2Configuration.class, CustomerDaoImpl.class, CustomerServiceImpl.class);
CustomerService pds = (CustomerService)ac.getBean("customerServiceImpl");*/
@RequestMapping(value="/all/getregistrationform")
public String getRegistrationForm(Model model)
{
	Customer customer=new Customer();
	model.addAttribute("customer", customer);
	return "registrationform1";
}
@RequestMapping(value="/all/registercustomer")
public String registerCustomer(@ModelAttribute Customer customer,Model model){
	String email=customer.getUser().getEmail();
	if(!cs.isEmailUnique(email)){//Email is duplicate, Not Unique
		model.addAttribute("errorMessage","Email already exists.. please choose different email id");
		return "registrationform1";
	}
	cs.registerCustomer(customer);
	
	return "loginpage";
}
}
