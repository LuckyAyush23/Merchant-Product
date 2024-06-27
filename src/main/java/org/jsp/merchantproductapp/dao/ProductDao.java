package org.jsp.merchantproductapp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;

public class ProductDao {
    
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	
	public Product saveProduct(Product p,int merchant_id) {
		EntityTransaction transaction = manager.getTransaction();
		Merchant merchant = manager.find(Merchant.class, merchant_id);
		if(merchant!=null) {
			merchant.getProducts().add(p);
			p.setMerchant(merchant);
			manager.persist(p);
			transaction.begin();
			transaction.commit();
			return p;
		}
		return null;
	}
	
	public Product updateProduct(Product p) {
		EntityTransaction transaction = manager.getTransaction();
		Product dbProduct = manager.find(Product.class, p.getId());
		if(dbProduct!=null) {
			dbProduct.setName(p.getName());
			dbProduct.setBrand(p.getBrand());
			dbProduct.setCategory(p.getCategory());
			dbProduct.setCost(p.getCost());
			dbProduct.setDescription(p.getDescription());
			manager.persist(p);
			transaction.begin();
			transaction.commit();
			return dbProduct;
		}
		return null;
		
	}
	
	public Product findById(int id){
		return manager.find(Product.class,id);
	}
	
	public List<Product> findByBrand(String brand){
//	   return manager.createQuery("select p from Product p where p.brand=?1").setParameter(1, brand).getResultList(); 
	    Query q = manager.createQuery("select p from Product p where p.brand=?1");
	    q.setParameter(1, brand);
	    return q.getResultList();
	}
	
	public List<Product> findByCategory(String category){
		   return manager.createQuery("select p from Product p where p.category=?1").setParameter(1, category).getResultList(); 
		}
	
	public List<Product> findByName(String name){
		   return manager.createQuery("select p from Product p where p.name=?1").setParameter(1, name).getResultList(); 
		}
	
	public List<Product> findByMerchantId(int merchant_id){
		   return manager.createQuery("select m.products from Merchant m where m.id=?1").setParameter(1, merchant_id).getResultList(); 
		}
	
	public List<Product> findAll(){
		Query q = manager.createQuery("select p from Product p");
		return q.getResultList();
	}
}
