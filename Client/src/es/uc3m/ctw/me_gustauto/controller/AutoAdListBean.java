package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

import javax.persistence.EntityManager;

public class AutoAdListBean {	
	// sorting orders
	public final String ASCENDING = "ASC", DESCENDING = "DESC";
	// autoAd fields
	public final String PRICE = "price", ENGINE = "engine", YEAR = "year",
			MILEAGE = "mileage", BRAND = "brand", DATE_ADDED = "addDate",
			AD_ID = "addId", COLOUR = "colour", DESCRIPTION = "description",
			MODEL = "model", REGISTRATION_NUMBER = "registrationNumber", TITLE = "title",
			VALID_UNTIL = "validTo";
	
	/**
	 * Get a list of all AutoAds
	 */
	public static List<?> getList() {
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		List<?> result = em.createQuery("SELECT a FROM AutoAd a").getResultList();
		em.close();
		return result;
	}
	
	/**
	 * Get a distinct list of all values of a column in AutoAds
	 */
	public static List<?> getList(String columnName) {
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		List<?> result = em.createQuery("SELECT DISTINCT a." + columnName + " FROM AutoAd a ORDER BY a." + columnName + " ASC").getResultList();
		em.close();
		return result;
	}
	
	
	public List<?> getSortedList(String field, String order){
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		List<?> result = em.createQuery("SELECT a FROM AutoAd a ORDER BY a.:f :o")
				.setParameter("f", field)
				.setParameter("o", order)
				.getResultList();
		em.close();
		return result;
	}
	
}
