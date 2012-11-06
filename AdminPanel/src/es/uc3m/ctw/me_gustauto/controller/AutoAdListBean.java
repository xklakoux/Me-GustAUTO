package es.uc3m.ctw.me_gustauto.controller;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.AutoAd;

public class AutoAdListBean {

	private static final String PERSISTENCE_UNIT_NAME = "megustauto";
	private static EntityManagerFactory factory;

	private List<AutoAd> list = new LinkedList<AutoAd>();

	public AutoAdListBean() {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = factory.createEntityManager();

		String jpql = "SELECT c FROM AutoAd c";
		Query query = em.createQuery(jpql); 
		list = query.getResultList();
	}

	public List<AutoAd> getList() {
		return list;
	}
}
