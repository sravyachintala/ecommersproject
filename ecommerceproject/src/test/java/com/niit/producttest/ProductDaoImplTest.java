/*package com.niit.producttest;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.H2Configuration;
import com.niit.dao.ProductDao;
import com.niit.daoimplementations.ProductDaoImpl;
import com.niit.model.Product;


public class ProductDaoImplTest extends TestCase{
	ApplicationContext ac=new AnnotationConfigApplicationContext(H2Configuration.class,ProductDaoImpl.class);
	ProductDao productDao=(ProductDao)ac.getBean("productDaoImpl");

	@Test
	public void testAddProducts() {
		Product p=new Product();
		p.setProductname("Watch");
		p.setProductdesc("Chopard");
		p.setQuantity(5);
		p.setPrice(75000);
		//p.setId(5);
		productDao.addProducts(p);
		assertTrue(p.getId()>0);
	}

	@Ignore
	@Test
	public void testUpdateProducts() {
		Product p= productDao.selectProducts(1);
		p.setPrice(2500000);
		productDao.updateProducts(p);
		p=productDao.selectProducts(1);
		assertTrue(p.getPrice() == 2500000);
	}
	@Ignore
	@Test
	public void testDeleteProducts() {
		productDao.deleteProducts(2);
		Product p=productDao.selectProducts(2);
		assertNull(p);
	}
	@Ignore
	@Test
	public void testSelectProducts() {
		Product actualproduct1=productDao.selectProducts(1);
		Product actualproduct2=productDao.selectProducts(45);
		assertNotNull(actualproduct1);
		assertNull(actualproduct2);
	}
	@Ignore
	@Test
	public void testGetAllProducts() {
		List<Product> p=productDao.getAllProducts();
		assertFalse(p.isEmpty());
		assertTrue(p.size()==1);
	}

}
*/