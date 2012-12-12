package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uc3m.ctw.me_gustauto.model.*;

/**
 * Servlet implementation class GetPricesServlet
 */
@WebServlet("/GetPricesServlet")
public class GetPricesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPricesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();
		List<Price> prices = (List<Price>) em.createQuery("select c from Price c").getResultList();
		request.setAttribute("prices", prices);
		for(Price price: prices){
			System.out.println("oto " + price.getMonths());
		}
		em.close();
		request.getRequestDispatcher("index.jsp?page=prices.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
