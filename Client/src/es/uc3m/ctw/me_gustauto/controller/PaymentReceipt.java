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
import es.uc3m.ctw.me_gustauto.model.GeneralAd;

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
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ad_id = Integer.valueOf(request.getParameter("id"));
		int months = Integer.valueOf(request.getParameter("months"));
		String type = request.getParameter("ad_type");
		int price = 20; // TODO
		
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();
		
		
		
		if(type.equals("auto")){
			AutoAd auto = em.find(AutoAd.class, ad_id);		
			request.setAttribute("auto", auto);
		}else if(type.equals("genad")){
			GeneralAd genad = em.find(GeneralAd.class, ad_id);
			request.setAttribute("genad", genad);	
		}
		
		//calculate price
		
		
		request.setAttribute("price", price);
		//propose promotions
		

		
		em.close();
		//redirect to confirmation page		
		request.getRequestDispatcher("/index.jsp?page=showreceipt.jsp").forward(request, response);
	}

}
