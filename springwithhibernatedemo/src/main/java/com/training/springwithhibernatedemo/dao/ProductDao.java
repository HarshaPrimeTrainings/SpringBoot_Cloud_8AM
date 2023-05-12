package com.training.springwithhibernatedemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public String saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(product);
		ts.commit();
		session.close();
		return "Prodcut Details Saved";
	}
	
	public List<Product> getProducts(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		 List<Product> prodcutList= session.createQuery("from Product").list();
		 ts.commit();
		 session.close();
		 return prodcutList;
	}
	
	@Transactional
	public Product findProduct(Integer pid) {
		Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			 Product pr = session.load(Product.class, pid);
			return pr;
	}
	
	public String deleteProduct(Integer pid) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction(); 
		Product pr = session.load(Product.class, pid);
		session.delete(pr);
		ts.commit();
		session.close();
		return "Product Deleted";
	}
	

}
