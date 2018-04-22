package com.myWebPage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myWebPage.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addProduct(Product product) {
		 Session session = sessionFactory.getCurrentSession();
	     Product theProduct = product;   
		 session.save(theProduct);
	}

	@Override
	@Transactional
	public Product getProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class, id);
		session.flush();
		
		return product;
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> products = query.list();
        session.flush();

        return products;
	}

	@Override
	@Transactional
	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();

	}
	@Override
	@Transactional
	public void editProduct(Product product) {
		 Session session = sessionFactory.getCurrentSession();
	     Product theProduct = product;   
		 session.save(theProduct);
	}

}
