package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uc3m.ctw.me_gustauto.model.*;

public class CommentsListBean {
	
	private int ad_id;
	
	public List<?> getList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("megustauto");
		EntityManager em = emf.createEntityManager();
		AutoAd autoad = em.find(AutoAd.class, ad_id);
		return em.createQuery("SELECT a FROM Comment a WHERE a.autoAd = :auto ORDER BY a.dateAdded DESC").setParameter("auto", autoad).getResultList(); 
	}

	public int getAd_id() {
		return ad_id;
	}

	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
}