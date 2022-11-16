package com.jbk.api.service;

import java.util.List;

import com.jbk.api.entity.Product;

public interface ProductService {
	
	public boolean saveProduct(Product product);
	public List<Product> getAllProducts();
	public boolean UpdateProduct(Product product);
	public Product getProductById(int productId);
	public boolean deleteProduct(int productId);
	public List<Product> getMaxPriceProducts();
	public double countSumOfProductPrice();
	public long getTotalCountOfProducts();
	public List<Product> sortProductById_ASC();
	public List<Product> sortProductByName_DESC();
	
	
	

}
