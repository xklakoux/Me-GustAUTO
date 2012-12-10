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
import es.uc3m.ctw.me_gustauto.model.GeneralAd;

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
		String ad_type = request.getParameter("ad_type");
		BankServicesProxy proxy = new BankServicesProxy();
		String number = request.getParameter("number1")+request.getParameter("number2")+request.getParameter("number3")+request.getParameter("number4");
		String result = proxy.validateCreditCard(number, request.getParameter("month"), request.getParameter("year"));
		
		
		
		if(result == null){
			request.setAttribute("bad_data", true);
			request.getRequestDispatcher("index.jsp?page=payment.jsp").forward(request, response);
		}else{
			
			// TODO: CONCILIATION TABLE?
			
			EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();			
			EntityTransaction et = em.getTransaction();			
			et.begin();
			
			if(ad_type.equals("auto")){
				AutoAd auto = em.find(AutoAd.class, Integer.valueOf(request.getParameter("id")));
				auto.setPaid(true);
			}else if(ad_type.equals("genad")){
				GeneralAd genad = em.find(GeneralAd.class, Integer.valueOf(request.getParameter("id")));
				genad.setPaid(true);
			}
			
			et.commit();
			em.close();			
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("index.jsp?page=paymentsuccess.jsp").forward(request, response);
		}
		
	}

}
