package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;

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
		Collections.shuffle(list);
		list = list.subList(0, Math.min(5, list.size() ));
		if(list!=null){
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("/bar-ads.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
