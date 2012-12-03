package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

import javax.persistence.EntityManager;

public class FavListBean {	
	public static List<?> getFavList(String username) {
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		List<?> result = em.createQuery("SELECT f FROM Fav f WHERE f.user.username = '" + username + "'").getResultList();
		em.close();
		return result;
	}
}
