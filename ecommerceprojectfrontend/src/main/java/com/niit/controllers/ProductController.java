package com.niit.controllers;



import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.configuration.H2Configuration;
import com.niit.daoimplementations.ProductDaoImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.service.ProductService;
import com.niit.serviceimplementations.ProductServiceImpl;






@Controller
public class ProductController {
@Autowired
private ProductService ps;
ApplicationContext ac = new AnnotationConfigApplicationContext(H2Configuration.class, ProductDaoImpl.class, ProductServiceImpl.class);
ProductService pds = (ProductService)ac.getBean("productServiceImpl");
public ProductController() {
	System.out.println("Product Controller Bean has been created");
}
@RequestMapping(value="/all/getallproducts/")
public String getAllProducts(Model m, HttpSession session)
{
	List<Product> products = ps.getAllProducts();
	m.addAttribute("product",products);
	session.setAttribute("categories", ps.getAllCategories());
	return "listofproducts";
}
@RequestMapping(value="/all/getproducts")
public String getProduct(@RequestParam int id,Model m)
{
	Product products = ps.selectProducts(id);
	m.addAttribute("productAttr",products);
	return "viewproduct";
}
@RequestMapping(value="/admin/deleteproduct")
public String deleteProduct(@RequestParam int id,Model m)
{
    ps.deleteProducts(id);
	return "redirect:/all/getallproducts/";
}
@RequestMapping(value="/admin/getproductform")
public String getProductForm(Model model)
{
	Product p=new Product();
	model.addAttribute("product",p);
	List<Category> categories=ps.getAllCategories();
	model.addAttribute("categories",categories);
  return "productform";
}
@RequestMapping(value="/admin/getcategoryform")
public String getCategoryForm(Model model)
{
	Category c=new Category();
	model.addAttribute("category",c);
  return "categoryform";
}
@RequestMapping(value="/admin/addcategory")
public String addCategory(@Valid @ModelAttribute Category category,BindingResult result)
{
	if(result.hasErrors())
	{
		
		return "categoryform";
		
	}
	ps.addCategory(category);
	return "redirect:/admin/getproductform/";
}
@RequestMapping(value="/admin/addproduct")
public String addProduct(@Valid @ModelAttribute Product product, BindingResult result,Model model, HttpServletRequest request)
{
	if(result.hasErrors())
	{
		List<Category> categories=ps.getAllCategories();
		model.addAttribute("categories",categories);
		return "productform";
		
	}
ps.addProducts(product);
MultipartFile img=product.getImage();
System.out.println(request.getServletContext().getRealPath("/"));
Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
//Path path=Paths.get("D:\\my project 1\\onlineshopping\\project1_frontend\\src\\main\\webapp\\WEB-INF\\resources\\images\\"+product.getId()+".png");
File file = new File(path.toString());
try
{
	img.transferTo(file);
}
catch(IllegalStateException e)
{
	e.printStackTrace();
}
catch(IOException e1)
{
	e1.printStackTrace();
}
return "redirect:/all/getallproducts/";
}
@RequestMapping(value="/admin/getupdateproductform")
public String getUpdateProductForm(@RequestParam int id, Model model)
{
	Product p=ps.selectProducts(id);
	model.addAttribute("product",p);
	List<Category> categories=ps.getAllCategories();
	model.addAttribute("categories",categories);
  return "updateproductform";
}
@RequestMapping(value="/admin/updateproduct")
public String updateProduct(@Valid @ModelAttribute Product product, BindingResult result,Model model, HttpServletRequest request)
{
	if(result.hasErrors())
	{
		List<Category> categories=ps.getAllCategories();
		model.addAttribute("categories",categories);
		return "updateproductform";
	}
ps.updateProducts(product);
MultipartFile img=product.getImage();
System.out.println(request.getServletContext().getRealPath("/"));


Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
File file = new File(path.toString());
try
{
	img.transferTo(file);
}
catch(IllegalStateException e)
{
	e.printStackTrace();
}
catch(IOException e1)
{
	e1.printStackTrace();
}
return "redirect:/all/getallproducts/";
}
@RequestMapping(value="/all/searchByCategory")
public String searchByCategory(@RequestParam String searchCondition, Model model)
{
	if(searchCondition.equals("All"))
	model.addAttribute("searchCondition","");
	else
	model.addAttribute("searchCondition",searchCondition);
	List<Product> products = ps.getAllProducts();
	model.addAttribute("product",products);
  return "listofproducts";
}
}