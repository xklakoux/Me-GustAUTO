package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;

import es.uc3m.ctw.me_gustauto.model.GeneralAd;


/**
 * Servlet implementation class GeneralAdServlet
 */
public class GeneralAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EntityManagerFactory emf;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneralAdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("megustauto");
		EntityManager manager = emf.createEntityManager();
		List<GeneralAd> list = (List<GeneralAd>) manager.createQuery("select b from GeneralAd b order by b.adId").getResultList();
		Collections.shuffle(list);
		list = list.subList(0, 5);
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
