package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		UserAccount account = entityManager.find(UserAccount.class, 1);
		if (account != null) {
			System.out.println("Account Id  :"+account.getId());
			System.out.println("Account User Name:"+account.getName());
			System.out.println("Account Email:"+account.getEmail());
			System.out.println("Account Password:"+account.getPassword());
			
			List<Page> list = account.getPage();
			for(Page page:list)
			{
				System.out.println("Page Id  :"+page.getId());
				System.out.println("Page  Name:"+page.getName());
				System.out.println("Page Title :"+page.getTitle());
				System.out.println("Page Description:"+page.getDescription());
			}
		}
	}
}
