package es.uc3m.ctw.me_gustauto.controller;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.GeneralAd;

public class GenAdListBean {

	private static final String PERSISTENCE_UNIT_NAME = "megustauto";
	private static EntityManagerFactory factory;

	private List<GeneralAd> list = new LinkedList<GeneralAd>();

	public GenAdListBean() {

		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		EntityManager em = factory.createEntityManager();

		String jpql = "SELECT c FROM GeneralAd c";
		Query query = em.createQuery(jpql); 
		list = query.getResultList();
	}

	public List<GeneralAd> getList() {
		return list;
	}
}
