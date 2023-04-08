package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSims {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("OPPO");
		mobile.setCost(18000.00);
		
		Sim sim1 = new Sim();
		sim1.setProvider("Jio");
		sim1.setType("4G");
		
		
		Sim sim2 = new Sim();
		sim2.setProvider("Airtel");
		sim2.setType("3G");
		
		List<Sim> list = new ArrayList<Sim>();
		list.add(sim1);
		list.add(sim2);
		
		mobile.setSim(list);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();
	}
}
