package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {
	public static void main(String[] args) {
		MerchantDao dao = new MerchantDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for save merchant");
		System.out.println("Enter 2 for update merchant");
		System.out.println("Enter 3 for find merchant");
		System.out.println("Enter 4 for verify merchant by phone and password");
		System.out.println("Enter 5 for verify merchant by email and password");
		
		System.out.println("-----------------------");
		System.out.println("enter option");
		switch (sc.nextInt()) {
		case 1: {
			Merchant m = new Merchant();
			System.out.println("Enter name,phone,email,gst_number,password");
			System.out.println("enter name");
			m.setName(sc.next());
			System.out.println("enter phone");
			m.setPhone(sc.nextLong());
			System.out.println("enter email");
			m.setEmail(sc.next());
			System.out.println("enter gst number");
			m.setGst_number(sc.next());
			System.out.println("enter password");
			m.setPassword(sc.next());
			m = dao.saveMerchant(m);
			System.out.println("Merchant saved with id " + m.getId());
			break;
		}
		
		case 2:{
			Merchant m = new Merchant();
			System.out.println("Enter name,phone,email,gst_number,password");
			System.out.println("enter id");
			m.setId(sc.nextInt());
			System.out.println("enter name");
			m.setName(sc.next());
			System.out.println("enter phone");
			m.setPhone(sc.nextLong());
			System.out.println("enter email");
			m.setEmail(sc.next());
			System.out.println("enter gst number");
			m.setGst_number(sc.next());
			System.out.println("enter password");
			m.setPassword(sc.next());
			m = dao.updateMerchant(m);
			if(m!=null) {
				System.out.println("Merchant updated successfully");
			}
			else {
				System.err.println("Cannot update merchant as id is invalid");
			}
			break;
		}
		case 3:{
			System.out.println("Enter merchant id to fetch the record");
			
			Merchant merchant = dao.findMerchant(sc.nextInt());
			if(merchant!=null) {
				System.out.println(merchant);
			}
			else {
				System.err.println("invalid merchant id");
			}
			break;
		}
		case 4:{
			System.out.println("Enter merchant phone and password to verify");
			long phone = sc.nextLong();
			String password = sc.next();
			Merchant m = dao.verifyMerchant(phone, password);
			if(m!=null) {
				System.out.println("Merchant is verified");
			}
			else {
				System.err.println("Invalid phone number or password");
			}
			break;
		}
		case 5:{
			System.out.println("Enter merchant phone and password to verify");
			String email = sc.next();
			String password = sc.next();
			Merchant m = dao.verifyMerchant(email, password);
			if(m!=null) {
				System.out.println("Merchant is verified");
			}
			else {
				System.err.println("Invalid phone number or password");
			}
			break;
		}
		}
	}
}
