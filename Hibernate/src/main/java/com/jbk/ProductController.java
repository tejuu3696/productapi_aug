package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.service.ProductService;

public class ProductController{
	
	public static void main(String args[]) {
		int choice;
		char ch;
		Scanner sc=new Scanner(System.in);
		ProductDao dao=new ProductDao();
		
		do {
			
			System.out.println("press 1 for save product");
			System.out.println("press 2 for get single product");
			System.out.println("press 3 for delete product");
			System.out.println("press 4 for update product");
			System.out.println("press 5 for get all product");
			System.out.println("press 6 for get product by name");
			System.out.println("press 7 for get product by higher price");
			System.out.println("press 8for get product by lower price");
			
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:{
				     Product product=ProductService.productInfo();
				     boolean isAdded=dao.saveProduct(product);
				     if(isAdded) {
				    	 System.out.println("product saved");
				     }
				     else {
				    	 System.out.println("product not saved");
				     }
				     break;
			       }
			case 2 : {
				System.out.println("enter product id");
				int id=sc.nextInt();
				Product product=dao.getProductById(id);
				if(product!=null) {
					System.out.println(product);
				      }
				else {
					System.out.println("product not found for thid id"+id);
				     }
				    break;
			        }
			case 3 : {
				System.out.println("Enter id");
				int id=sc.nextInt();
				boolean isDeleted=dao.deleteProductById(id);
				if(isDeleted) {
					System.out.println("product is deleted");
				}else {
					System.out.println("product not found for thid id"+id);
				}
				break;
			}
			case 4 :{
				
				Product product=ProductService.productInfo();
				boolean isUpdated=dao.updateProduct(product);
				if(isUpdated) {
					System.out.println("product is updated");
				}else {
					System.out.println("product not found for this id"+product.getProductId());
				}
				break;
			}
			case 5 :	{
				List<Product> list=dao.getAllProducts();
				if(!list.isEmpty()) {
					for(Product product :list) {
						System.out.println(product);
					}
				}
				break;
			}
			case 6 :{
				System.out.println("enter product name");
				String productName=sc.next();
				Product product=dao.getProductByName(productName);
				if(product!=null) {
					System.out.println(product);
				}else {
					System.out.println("product not found for this name"+productName);
				}
				break;
			}
			case 7 :{
				System.out.println("enter product price");
				double productPrice=sc.nextDouble();
				List<Product> list=dao.getProductByPrice(productPrice);
				if(list!=null) {
					for(Product product :list) {
						System.out.println(product);
					}
				}
					
				break;
			}
			case 8:{
				System.out.println("enter minimum product price");
				double productPrice=sc.nextDouble();
				List<Product> list=dao.getProductByLowerPrice(productPrice);
				if(list!=null) {
					for(Product product :list) {
						System.out.println(product);
					
					}
				
				}
					
				break;
			}
			default:
				break;
			}
			System.out.println("do you want to continue y/n");
			ch=sc.next().charAt(0);
		} while(ch=='y' ||ch=='Y');
	}

}
