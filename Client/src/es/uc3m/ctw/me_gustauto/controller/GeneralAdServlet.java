package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.ejb.AdvertisementRemote;

/**
 * Servlet implementation class GeneralAdServlet
 */
public class GeneralAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */	
    public GeneralAdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		List<?> list = em.createQuery("select b from GeneralAd b order by b.adId").getResultList();
		em.close();
		
		LinkedList<Object> sublist = new LinkedList<Object>();
		try {
	        InitialContext context = new InitialContext();
	        AdvertisementRemote bean = (AdvertisementRemote) context.lookup("es.uc3m.ctw.me_gustauto.ejb.AdvertisementRemote");
	        for (Integer i : bean.getRandomIndexesForGeneralAds(list.size())) {
	        	sublist.add(list.get(i));
	        }
	    } catch(Exception e) {
	       	e.printStackTrace();
	    }
		
		request.setAttribute("list", sublist);
		request.getRequestDispatcher("/bar-ads.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
