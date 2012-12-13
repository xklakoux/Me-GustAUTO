package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 * Servlet implementation class SavePricesServlet
 */
@WebServlet("/SavePricesServlet")
public class SavePricesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePricesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();
		List<Price> ids = (List<Price>) em.createQuery("select c from Price c").getResultList();
		for(Price pr: ids){
			Price price = em.find(Price.class, pr.getPriceId());
			em.getTransaction().begin();
			BigDecimal value = BigDecimal.valueOf(Float.parseFloat(request.getParameter(String.valueOf(pr.getPriceId()))));
			price.setPrice(value);
			em.getTransaction().commit();
		}
		Promo prmo = (Promo) em.createQuery("select c from Promo c").getResultList().get(0);
		em.getTransaction().begin();
		prmo.setPerc(Integer.valueOf(request.getParameter("perc")));
		prmo.setValid(Boolean.parseBoolean(request.getParameter("valid")));
		em.getTransaction().commit();
		
		List<Price> prices = (List<Price>) em.createQuery("select c from Price c").getResultList();
		request.setAttribute("prices", prices);
		Promo promo = (Promo) em.createQuery("select c from Promo c").getResultList().get(0);
		request.setAttribute("promo", promo);
		em.close();
		request.getRequestDispatcher("index.jsp?page=editprices.jsp").forward(request, response);
		
	}

}
