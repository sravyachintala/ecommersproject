package com.niit.daoimplementations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	private SessionFactory sf;
	public void addToCart(CartItem cartItem) {
		Session s=sf.openSession();
		s.save(cartItem);
		System.out.println("SAVE OR UPDATE");
	}
	@Override
	public void deleteFromCart(int id) {
		Session  s = sf.getCurrentSession();
		
		CartItem  p=(CartItem )s.get(CartItem.class,id);
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
	/*@Override
	public void removeAllCartItem() {
		String hql = "delete from CartItem where cartid!=0";
		Session s=sf.getCurrentSession();
	    Query query = s.createQuery(hql);
	    
		query.executeUpdate();
		s.flush();
	}
	@Override
	public double getTotalPrice() {
		 double totalprice=0.0;
		 Session  s = sf.getCurrentSession();
		 Query query=s.createQuery("from CartItem");
		 List<CartItem> cartItem=query.list(); 
			if(!cartItem.isEmpty())
			 {
		  String hql = "select sum(totalprice) from CartItem";
		  s=sf.openSession();
	      Query query1 = s.createQuery(hql);
	      totalprice=(Double)query1.uniqueResult();
			 }
			s.flush();
		return totalprice;
	}
	@Override
	public long getCount() {
	long count=0;
		Session  s = sf.getCurrentSession();
		 Query query=s.createQuery("from CartItem");
		 List<CartItem> cartItem=query.list(); 
			if(!cartItem.isEmpty())
			 {
		  String hql = "select count(*) from CartItem";
		  s=sf.openSession();
	      Query query1 = s.createQuery(hql);
	      count=(Long)query1.uniqueResult();
			 }
			s.flush();
		return count;
	}*/
	@Override
	public List<CartItem> getCart(String email) {
		Session  s = sf.getCurrentSession();
		 Query query=s.createQuery("from CartItem where user.email=?");
		 query.setString(0, email);
		return  query.list();
	}
	@Override
	public void removeCartItem(int cartItemId) {
		Session s=sf.getCurrentSession();
		CartItem cartItem=(CartItem)s.get(CartItem.class, cartItemId);
		s.delete(cartItem);
	}
	@Override
	public void createCustomerOrder(CustomerOrder customerOrder) {
		Session s=sf.getCurrentSession();
		s.save(customerOrder);
		
	}

}
