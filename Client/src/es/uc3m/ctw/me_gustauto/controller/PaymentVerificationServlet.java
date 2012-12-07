package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.AutoAd;

import jhc.ws.BankServicesProxy;

/**
 * Servlet implementation class PaymentVerificationServlet
 */
@WebServlet("/PaymentVerificationServlet")
public class PaymentVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentVerificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BankServicesProxy proxy = new BankServicesProxy();
		String result = proxy.validateCreditCard(request.getParameter("number"), request.getParameter("month"), request.getParameter("year"));
		
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();
		AutoAd auto = em.find(AutoAd.class, Integer.valueOf(request.getParameter("id")));
		
		
		
		
		
		if(result == null){
			request.setAttribute("bad_data", true);
			request.getRequestDispatcher("index.jsp?page=payment.jsp").forward(request, response);
		}else{
			
			// TODO: CONCILIATION TABLE?
			
			request.setAttribute("result", result);
	
			EntityTransaction et = em.getTransaction();
			et.begin();
			auto.setPaid(true);
			et.commit();
		
			request.getRequestDispatcher("index.jsp?page=paymentsuccess.jsp").forward(request, response);
		}
		
		
		
		em.close();
		
		
	}

}
