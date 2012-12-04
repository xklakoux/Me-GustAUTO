package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.AutoAd;

/**
 * Servlet implementation class PaymentReceipt
 */
@WebServlet("/PaymentReceipt")
public class PaymentReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PaymentReceipt() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ad_id = Integer.valueOf(request.getParameter("id"));
		int months = Integer.valueOf(request.getParameter("months"));
		int price = 0;
		
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();
		AutoAd auto = em.find(AutoAd.class, ad_id);
		
		
		
		//calculate price
		
		
		request.setAttribute("price", price);
		//propose promotions
		

		
		em.close();
		//redirect to confirmation page		
		request.getRequestDispatcher("/index.jsp?page=showreceipt.jsp").forward(request, response);
		
	}

}
