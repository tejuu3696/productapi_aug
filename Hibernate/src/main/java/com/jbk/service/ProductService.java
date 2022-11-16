package com.jbk.service;

import java.util.Scanner;

import com.jbk.entity.Product;


public class ProductService {
	public static Product productInfo() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		
		System.out.println("enter product name");
		String name=sc.next();
		
		System.out.println("enter product price");
		double price=sc.nextDouble();
		
		System.out.println("enter product type");
		String type=sc.next();
		
		Product product=new Product(id,name,price,type);                                                          
		return product;
		
	}

}
