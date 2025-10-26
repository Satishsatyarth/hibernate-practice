package com.jspider.hibernate_JPAand_HQL_CRUD;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // ===== Customer 1 =====
        Customer c1 = new Customer();
        c1.setName("Ramesh");
        c1.setEmail("ramesh@gmail.com");

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(123568.23);
        p1.setCustomer(c1); // ✅ establish relationship from child side

        Product p2 = new Product();
        p2.setName("Mobile");
        p2.setPrice(43568.23);
        p2.setCustomer(c1); // ✅

        List<Product> productList1 = new ArrayList<>();
        productList1.add(p1);
        productList1.add(p2);
        c1.setProduct(productList1); // ✅ establish relationship from parent side

        // ===== Customer 2 =====
        Customer c2 = new Customer();
        c2.setName("Barun");
        c2.setEmail("barun@gmail.com");

        Product p3 = new Product();
        p3.setName("Headphones");
        p3.setPrice(8568.99);
        p3.setCustomer(c2); // ✅

        List<Product> productList2 = new ArrayList<>();
        productList2.add(p3);
        c2.setProduct(productList2); // ✅

        // ===== Save to DB =====
        et.begin();
        em.persist(c1);  // ✅ cascade will also save products
        em.persist(c2);
        et.commit();

        em.close();
        emf.close();
        
        System.out.println("Data inserted Succesfully");
    }
}
