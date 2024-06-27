package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Product;

public class ProductController {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter option");
		System.out.println("----------------------");
		System.out.println("enter option 1 to save the product");
		System.out.println("enter option 2 to update the product");
		System.out.println("enter option 3 to find the product by id");
		System.out.println("enter option 4 to find the product by brand");
		System.out.println("enter option 5 to find the product by category");
		System.out.println("enter option 6 to find the product by name");
		System.out.println("enter option 7 to find the product by merchant id");
		System.out.println("enter option 8 to find all products");
		System.out.println("================================");
		switch (sc.nextInt()) {
		case 1: {
			System.out.println("Enter merchant id");
			int merchant_id = sc.nextInt();
			System.out.println("enter product name,brand,category,cost,description");
			Product p = new Product();
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setCost(sc.nextDouble());
			p.setDescription(sc.next());
			p = dao.saveProduct(p, merchant_id);
			if (p != null) {
				System.out.println("Product saved with id " + p.getId());

			} else {
				System.err.println("Cannot saved product due to invalid id");
			}
			break;
		}
		case 2:{
			
			Product p = new Product();
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setCost(sc.nextDouble());
			p.setDescription(sc.next());
			p = dao.updateProduct(p);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.err.println("cannot update id as product id is invalid");
			}
			break;
		}
		case 3:{
			System.out.println("enter product id");
			Product p = dao.findById(sc.nextInt());
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.err.println("invalid id");
			}
			break;
		} 
		
		case 4:{
			System.out.println("enter brand name");
			List<Product> products = dao.findByBrand(sc.nextLine());
			if(products!=null) {
				for(Product p : products) {
					System.out.println(p);
				}
			}
			else {
				System.err.println("invalid brand name");
			}
			break;
		}
		case 5:{
			System.out.println("enter category name");
			List<Product> products = dao.findByCategory(sc.nextLine());
			if(!products.isEmpty()) {
				for(Product p : products) {
					System.out.println(p);
				}
			}
			else {
				System.err.println("invalid category name");
			}
			break;
		}
		
		case 6:{
			System.out.println("enter product name");
			List<Product> products = dao.findByName(sc.nextLine());
			if(products!=null) {
				for(Product p : products) {
					System.out.println(p);
				}
			}
			else {
				System.err.println("invalid product name");
			}
			break;
		}
		case 7:{
			System.out.println("enter merchant id");
			List<Product> products = dao.findByMerchantId(sc.nextInt());
			if(products!=null) {
				for(Product p : products) {
					System.out.println(p);
				}
			}
			else {
				System.err.println("invalid merchant id");
			}
			break;
		}
		case 8:{
			List<Product> products = dao.findAll();
			if(products!=null) {
				for(Product p : products) {
					System.out.println(p);
				}
			}
			else {
				System.err.println("No Product found");
			}
		}
		}
	}
}
