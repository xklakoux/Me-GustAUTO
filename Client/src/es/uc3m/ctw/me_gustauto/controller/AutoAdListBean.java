package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

import javax.persistence.Persistence;

public class AutoAdListBean {	
	// sorting orders
	public final String ASCENDING = "ASC", DESCENDING = "DESC";
	// autoAd fields
	public final String PRICE = "price", ENGINE = "engine", YEAR = "year",
			MILEAGE = "mileage", BRAND = "brand", DATE_ADDED = "addDate",
			AD_ID = "addId", COLOUR = "colour", DESCRIPTION = "description",
			MODEL = "model", REGISTRATION_NUMBER = "registrationNumber", TITLE = "title",
			VALID_UNTIL = "validTo";
	// operators for filtering
	public final String BIGGER = ">", SMALLER = "<", EQUAL = "=", SMALLER_EQUAL = "<=", BIGGER_EQUAL = ">=";
	
	/**
	 * Get a list of all AutoAds
	 */
	public List<?> getList() {
		return MySQLConnector.executeQuery("SELECT a FROM AutoAd a");
	}
	
	/**
	 * Get a distinct list of all values of a column in AutoAds
	 */
	public List<?> getList(String columnName) {
		return Persistence.createEntityManagerFactory("megustauto").createEntityManager().createQuery("SELECT DISTINCT a." + columnName + " FROM AutoAd a ORDER BY a." + columnName + " ASC").getResultList();
	}
	
	/**
	 * 
	 * @param field AutoAdListBean.PRICE or any other AutoAd field name
	 * @param order AutoAdListBean.ASCENDING or AutoAdListBean.DESCENDING
	 * @return list of auto ads sorted ascending or descending by a given field
	 */
	public List<?> getSortedList(String field, String order){
		return Persistence.createEntityManagerFactory("megustauto").createEntityManager().createQuery("SELECT a FROM AutoAd a ORDER BY a.:f :o")
					.setParameter("f", field)
					.setParameter("o", order)
					.getResultList();
	}
	
	
	// what comes next might be useful for searching
	/**
	 * 
	 * @param field AutoAdListBean.PRICE or any other AutoAd field name
	 * 
	 * @param relation AutoAdListBean.BIGGER SMALLER EQUAL SMALLER_EQUAL BIGGER_EQUAL
	 * @param value 
	 * @return list of ads that fulfill the specified requirement
	 */
	public List<?> getFilteredList(String field, String relation, String value){
		return Persistence.createEntityManagerFactory("megustauto").createEntityManager().createQuery("SELECT a FROM AutoAd a WHERE a.:f :r :v")
					.setParameter("f", field)
					.setParameter("r", relation)
					.setParameter("v", value)
					.getResultList();		
	}
	
	public List<?> getListFromQuery(String query){
		return Persistence.createEntityManagerFactory("megustauto").createEntityManager().createQuery(query).getResultList();
	}
}
