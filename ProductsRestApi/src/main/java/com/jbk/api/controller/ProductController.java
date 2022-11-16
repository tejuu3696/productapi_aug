package com.jbk.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.api.entity.Product;
import com.jbk.api.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(value = "/product/saveProduct")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product product) {

		boolean isAdded = service.saveProduct(product);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);

		}
	}

	@GetMapping(value = "/getproduct/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {
		Product product = service.getProductById(productId);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/getallproducts/<list>")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = service.getAllProducts();
		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		}
	}

	@PutMapping(value = "/updateproduct/{productId}")
	public ResponseEntity<Boolean> UpdateProduct(@RequestBody Product product, @PathVariable int productId) {
		boolean isUpdated = service.UpdateProduct(product);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/deleteproduct/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable int productId) {
		boolean isDeleted = service.deleteProduct(productId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.FOUND);
		} else {

			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}

	}
	
	@GetMapping(value = "/get_max_price_products")
	public ResponseEntity<List<Product>> getMaxPriceProducts() {

		List<Product> maxPriceProducts = service.getMaxPriceProducts();

		return new ResponseEntity<List<Product>>(maxPriceProducts, HttpStatus.OK);

	}
	
	@GetMapping(value = "/count_sum_of_product_price")
	public ResponseEntity<Double> countSumOfProductPrice() {

		double sumOfProducts = service.countSumOfProductPrice();

		return new ResponseEntity<Double>(sumOfProducts, HttpStatus.OK);

	}
	
	@GetMapping(value = "/get_total_count_of_products")
	public ResponseEntity<Long> getTotalCountOfProducts() {

		long countOfProducts = service.getTotalCountOfProducts();

		return new ResponseEntity<Long>(countOfProducts, HttpStatus.OK);

	}
	
	@GetMapping("/ascending_product_by_id")
	public List<Product> ascendingProductById(){
		List<Product> list=service.sortProductById_ASC();
		System.out.println(list);
		return list;
	}
	@GetMapping("/descending_product_by_name")
	public List<Product> descendingProductByName(){
		List<Product> list=service.sortProductByName_DESC();
		System.out.println(list);
		return list;
	}


}
