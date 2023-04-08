package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileSims {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Mobile mobile = entityManager.find(Mobile.class,2);
		
		if(mobile != null)
		{
			System.out.println("Mobile Id  :"+mobile.getId());
			System.out.println("Mobile Name:"+mobile.getName());
			System.out.println("Mobile Cost:"+mobile.getCost());
			System.out.println("--------------------------------------");
			List<Sim> list = mobile.getSim();
			for(Sim sim:list)
			{
				System.out.println("Sim Id    :"+sim.getId());
				System.out.println("Sim Provider:"+sim.getProvider());
				System.out.println("Sim Type  :"+sim.getType());
				System.out.println("---------------------------------");
			}
		}
		else
		{
			System.out.println("No data is found");
		}
		
		
	}
}
