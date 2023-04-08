package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSvaeAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserAccount account = new UserAccount();
		account.setName("Priya");
		account.setEmail("pi@mail.com");
		account.setPassword("Priya123");
		
		List<Page> list = new ArrayList<Page>();
		
		Page page1 = new Page();
		page1.setName("FaceBook");
		page1.setTitle("sender");
		page1.setDescription("chat with others");
		
		Page page2 = new Page();
		page2.setName("FaceBook");
		page2.setTitle("Short TV");
		page2.setDescription("saw a story");
		
		list.add(page1);
		list.add(page2);
		
		account.setPage(list);
		
		entityTransaction.begin();
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityManager.persist(account);
		entityTransaction.commit();
	}
}
