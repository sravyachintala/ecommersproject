package com.niit.serviceimplementations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;
	public ProductServiceImpl() {         
		System.out.println("ProductServiceImplementation Bean Has Been Created");
	}
	public void addProducts(Product product) {
	pdao.addProducts(product);
	}
	public void updateProducts(Product product) {
		pdao.updateProducts(product);	
	}
	public void deleteProducts(int id) {
		pdao.deleteProducts(id);
	}
	public Product selectProducts(int id) {
		return pdao.selectProducts(id);
	}
	public List<Product> getAllProducts()
	{
		return pdao.getAllProducts();
	}
	@Override
	public List<Category> getAllCategories() {
		
		return pdao.getAllCategories();
	}
	@Override
	public void addCategory(Category category) {
		pdao.addCategory(category);
		
	}
}
