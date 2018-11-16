package com.niit.crudoperation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.H2Configuration;
import com.niit.daoimplementations.ProductDaoImpl;
import com.niit.model.Product;
import com.niit.service.ProductService;
import com.niit.serviceimplementations.ProductServiceImpl;


public class ProductDelete {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(H2Configuration.class,ProductDaoImpl.class,ProductServiceImpl.class);
		ProductService pds=(ProductService)ac.getBean("productServiceImpl");
		Product p=new Product();
		/*p.setProductname("Car");
		p.setProductdesc("BENZ GRAY");
		p.setQuantity(1);
		p.setPrice(1500000);*/
		
		pds.deleteProducts(1);
	}

}
