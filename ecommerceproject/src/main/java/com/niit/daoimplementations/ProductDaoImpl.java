package com.niit.daoimplementations;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sf;
	public ProductDaoImpl() {
		System.out.println("ProductDaoImplementation Bean Has Been Created");
	}
	public void addProducts(Product product) {
	Session  s = sf.getCurrentSession();
	//************************************************** INSERTION THROUGH SAVE() METHOD ************************************************************
		/*int pk=(Integer)s.save(product);
		 * if(pk != 0)
		{
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("************************************************** INSERTION THROUGH SAVE() METHOD ************************************************************");
			System.out.println("PRODUCT RECORD INSERTED SUCCESSFULLY");
		}
		else
		{
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("PRODUCT RECORD INSERTION FAILED");
		}*/
		s.saveOrUpdate(product);
		
		//************************************************** INSERTION THROUGH PERSIST() METHOD ****************************************
		/*try{
			 s.persist(product);
			 System.out.println("************************************************** INSERTION THROUGH PERSIST() METHOD ****************************************");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("RECORD INSERTED SUCCESSFULLY");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("RECORD INSERTION FAILED");
		}*/
		//************************************************** INSERTION THROUGH SAVEORUPDATE() METHOD ****************************************
				/*try{
					 s.saveOrUpdate(product);
					 System.out.println("************************************************** INSERTION THROUGH SAVEORUPDATE() METHOD ****************************************");
					 System.out.println("--------------------------------------------------------------------------------------------------------");
					 System.out.println("RECORD INSERTED SUCCESSFULLY");
				}
				catch(Exception e)
				{
					e.printStackTrace();
					 System.out.println("--------------------------------------------------------------------------------------------------------");
					System.out.println("RECORD INSERTION FAILED");
				}*/
		s.flush();
	}
	public void updateProducts(Product product) {
		Session  s = sf.getCurrentSession();
		//************************************************** UPDATION THROUGH UPDATE() METHOD ************************************************************
		try{
			s.update(product);
			 System.out.println("************************************************** UPDATION THROUGH UPDATE() METHOD ****************************************");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("RECORD UPDATED SUCCESSFULLY");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("RECORD UPDATION FAILED");
		}
		//************************************************** UPDATION THROUGH MERGE() METHOD ************************************************************
		/*try{
			  s.merge(product);
			  System.out.println("**************************************************UPDATION THROUGH MERGE() METHOD ****************************************");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("RECORD UPDATED SUCCESSFULLY");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("RECORD UPDATION FAILED");
		}*/
		s.flush();
	}
	public void deleteProducts(int id) {
		Session  s = sf.getCurrentSession();
		
			 Product p=(Product)s.get(Product.class,id);
			 if(p != null)
			 {
				 try{
					 s.delete(p);
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("RECORD DELETED SUCCESSFULLY");
			 }
			 catch(Exception e)
			 {
					e.printStackTrace();
	
			 }
			 }
			 else
			 {
				 System.out.println("--------------------------------------------------------------------------------------------------------");
					System.out.println("RECORD DELETION FAILED");
			 }
		
		s.flush();
	}
	public Product selectProducts(int id) {
		
		Session  s = sf.getCurrentSession();
		//************************************************** SELECTION THROUGH GET() METHOD ************************************************************
		
			 Object obj=(Object)s.get(Product.class,id);
			 Product p=(Product)obj;
			 if(p!=null)
			 {

				 System.out.println("");
				 System.out.println("************************************************** SELECTION THROUGH GET() METHOD ************************************************************");
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				 System.out.println("PRODUCT ID"+"\t"+"PRODUCT NAME"+"\t"+"PRODUCT DESCRIPTION"+"\t"+"PRODUCT PRICE"+"\t"+"PRODUCT QUANTITY");
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				 System.out.println(p.getId()+"\t\t"+p.getProductname()+"\t\t"+p.getProductdesc()+"\t\t"+p.getPrice()+"\t\t"+p.getQuantity());
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				 System.out.println("RECORD RETRIEVED SUCCESSFULLY");
			 }
			else
				{
					
					System.out.println("RECORD RETRIEVAL FAILED");
				}
			 /*System.out.println("");
			 System.out.println("************************************************** SELECTION THROUGH GET() METHOD ************************************************************");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("PRODUCT ID"+"\t"+"PRODUCT NAME"+"\t"+"PRODUCT DESCRIPTION"+"\t"+"PRODUCT PRICE"+"\t"+"PRODUCT QUANTITY");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println(p.getId()+"\t\t"+p.getProductname()+"\t\t"+p.getProductdesc()+"\t\t"+p.getPrice()+"\t\t"+p.getQuantity());
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("RECORD RETRIEVED SUCCESSFULLY");*/
		
		//************************************************** SELCETION THROUGH LOAD() METHOD ************************************************************
		/*try{
			 Object obj=(Object)s.load(Product.class,1);
			 Product p=(Product)obj;
			 System.out.println("");
			 System.out.println("************************************************** SELCETION THROUGH LOAD() METHOD ************************************************************");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("PRODUCT ID"+"\t"+"PRODUCT NAME"+"\t"+"PRODUCT DESCRIPTION"+"\t"+"PRODUCT PRICE"+"\t"+"PRODUCT QUANTITY");
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println(p.getId()+"\t\t"+p.getProductname()+"\t\t"+p.getProductdesc()+"\t\t"+p.getPrice()+"\t\t"+p.getQuantity());
			 System.out.println("--------------------------------------------------------------------------------------------------------");
			 System.out.println("RECORD RETRIEVED SUCCESSFULLY");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("RECORD RETRIEVAL FAILED");
		}*/
		//************************************************** MULTIPLE ROW SELCETION THROUGH LOAD() METHOD ************************************************************
				/*try{
					EntityManager em;
					Session session = em.unwrap(Session.class);
					MultiIdentifierLoadAccess<Product> multiLoadAccess = session.byMultipleIds(Product.class);
					List<Product> products = multiLoadAccess.multiLoad(1, 2, 3);
					 System.out.println("");
					 System.out.println("************************************************** SELCETION THROUGH LOAD() METHOD ************************************************************");
					 System.out.println("--------------------------------------------------------------------------------------------------------");
					 System.out.println("PRODUCT ID"+"\t"+"PRODUCT NAME"+"\t"+"PRODUCT DESCRIPTION"+"\t"+"PRODUCT PRICE"+"\t"+"PRODUCT QUANTITY");
					 System.out.println("--------------------------------------------------------------------------------------------------------");
					 System.out.println(p.getId()+"\t\t"+p.getProductname()+"\t\t"+p.getProductdesc()+"\t\t"+p.getPrice()+"\t\t"+p.getQuantity());
					 System.out.println("--------------------------------------------------------------------------------------------------------");
					 System.out.println("RECORD RETRIEVED SUCCESSFULLY");
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("RECORD RETRIEVAL FAILED");
				}*/
		
		s.flush();
		 return p;
	}
	public List<Product> getAllProducts()
	{
		Session session=sf.getCurrentSession();
			Query query	=session.createQuery("from Product");
			List<Product> product=query.list();
		return product;
		
	}
	@Override
	public List<Category> getAllCategories() {
		Session session=sf.getCurrentSession();
		Query query	=session.createQuery("from Category");
		List<Category> category=query.list();
		return category;
	}
	@Override
	public void addCategory(Category category) {
		Session  s = sf.getCurrentSession();
		//************************************************** INSERTION THROUGH SAVE() METHOD ************************************************************
			int pk=(Integer)s.save(category);
			if(pk != 0)
			{
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("************************************************** INSERTION THROUGH SAVE() METHOD ************************************************************");
				System.out.println("CATEGORY RECORD INSERTED SUCCESSFULLY");
			}
			else
			{
				System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("CAETGORY RECORD INSERTION FAILED");
			}
			s.flush();
	}
}
