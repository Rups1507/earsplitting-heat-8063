package com.masai.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("B28_CW");
	static EntityManager em = null;
	
	public static EntityManager getEntityManager() {
		if(em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}
	
	
	
}
