package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.uc3m.ctw.me_gustauto.model.*;

public class CommentsListBean {
	
	private int ad_id;
	
	public List<Object> getList() {
		EntityManagerFactory emf = MySQLConnector.factory;
		EntityManager em = emf.createEntityManager();
		AutoAd autoad = em.find(AutoAd.class, ad_id);
		return em.createQuery("select a from Comment a where a.autoAd = :auto").setParameter("auto", autoad).getResultList();
		
	}

	public int getAd_id() {
		return ad_id;
	}

	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
}