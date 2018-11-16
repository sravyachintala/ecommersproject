package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface ProductDao {
public void addProducts(Product p);
public void updateProducts(Product p);
public void deleteProducts(int id);
public Product selectProducts(int id);
public List<Product> getAllProducts();
public List<Category> getAllCategories();
public void addCategory(Category category);
}
