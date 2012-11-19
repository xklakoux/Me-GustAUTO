package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("megustauto");
		EntityManager manager = emf.createEntityManager();
		Random rand = new Random();
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
		// TODO Auto-generated method stub
	}

}
