package com.jbk.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.api.dao.ProductDao;
import com.jbk.api.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductDao dao;
	@Override
	public boolean saveProduct(Product product) {
	boolean isAdded=dao.saveProduct(product);
		return isAdded;
	}
	@Override
	public Product getProductById(int productId) {
		Product product=dao.getProductById(productId);
		return product;
	}
	@Override
	public List<Product> getAllProducts() {
		List<Product> list=dao.getAllProducts();
		return list;
	}
	@Override
	public boolean UpdateProduct(Product product) {
		boolean isUpdated=dao.UpdateProduct(product);
		return isUpdated;
	}
	@Override
	public boolean deleteProduct(int productId) {
		boolean isDeleted=dao.deleteProduct(productId);
		return isDeleted;
	}
	@Override
	public List<Product> getMaxPriceProducts() {
		List<Product> list=dao.getMaxPriceProducts();
		return list;
	}
	@Override
	public double countSumOfProductPrice() {
		
		return dao.countSumOfProductPrice();
	}
	@Override
	public long getTotalCountOfProducts() {
		return dao.getTotalCountOfProducts();
	}
	@Override
	public List<Product> sortProductById_ASC() {
		return dao.sortProductById_ASC();
	}
	@Override
	public List<Product> sortProductByName_DESC() {
		return dao.sortProductByName_DESC();
	}

	
	
}