package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteAccountPage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserAccount account = entityManager.find(UserAccount.class, 1);
	
		List<Page> list = account.getPage();
		
		entityTransaction.begin();
		
		for(Page page:list) {
			entityManager.remove(page);
		}
		entityManager.remove(account);
		
		entityTransaction.commit();
	}
}