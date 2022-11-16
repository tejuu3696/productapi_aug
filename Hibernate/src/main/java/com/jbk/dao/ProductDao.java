package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jbk.config.HibernateUtility;
import com.jbk.entity.Product;

public class ProductDao {
	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

	public boolean saveProduct(Product product) {
		boolean isAdded = false;
		Session session = sessionFactory.openSession();

		try {

			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	public Product getProductById(int productId) {
		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;

	}
	
	public boolean deleteProductById(int productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		boolean isDeleted=false;
		try {
			Product product=session.get(Product.class, productId);
			if(product!=null)
				session.delete(product);
			transaction.commit();
			isDeleted=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return isDeleted;
		
	}
	public boolean updateProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		boolean isUpdated=false;
		try {
			Product prd=session.get(Product.class,product.getProductId());
			session.evict(prd);
			if(prd!=null) {
				session.update(product);
				transaction.commit();
				isUpdated=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	public List<Product> getAllProducts(){
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			list=criteria.list();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		if(session!=null) {
			session.close();
		}
		}
		return list;
		
	}
	public Product getProductByName(String productName) {
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		Product product=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", productName));
			list=criteria.list();
			if(!list.isEmpty()) {
			product=list.get(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return product;
	}
	public List<Product> getProductByPrice(double productPrice) {
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		Product product=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", productPrice));
			list=criteria.list();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}
	public List<Product> getProductByLowerPrice(double productPrice) {
		Session session=sessionFactory.openSession();
		List<Product> list=null;
		Product product=null;
		try {
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.lt("productPrice", productPrice));
			list=criteria.list();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}
	
	
}
