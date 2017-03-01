package com.pcc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.pcc.jpa_model.*;

public class App {
	private static final String UNIT = "JPA-Beispiel";
	private static EntityManagerFactory factory;
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(UNIT);
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		EMP e = new EMP();
		e.setName("Frank");
		e.setJob("Banker");
		e.setSal(3812.87);
		em.persist(e);
		em.getTransaction().commit();
		/*
		 * Erstellen einer abfrage in form von select * fom emp;
		 * 
		 */
		Query q = em.createQuery("SELECT e from EMP e");
		List<EMP>  qliste = q.getResultList();
		for (EMP ergo : qliste){
			System.out.println(ergo.getId() + " :: " + ergo.getName() + " : " + ergo.getJob() + " : " + ergo.getSal() );
		}
		em.close();
	}

}
