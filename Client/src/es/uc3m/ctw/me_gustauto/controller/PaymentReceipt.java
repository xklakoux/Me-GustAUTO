package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.AutoAd;
import es.uc3m.ctw.me_gustauto.model.GeneralAd;
import es.uc3m.ctw.me_gustauto.model.Price;
import es.uc3m.ctw.me_gustauto.model.Promo;
import es.uc3m.ctw.me_gustauto.model.User;

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
		String type = request.getParameter("ad_type");
		BigDecimal price;
		
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();
		
		
		
		if(type.equals("auto")){
			AutoAd auto = em.find(AutoAd.class, ad_id);		
			request.setAttribute("auto", auto);
			type = "Auto";
		}else if(type.equals("genad")){
			GeneralAd genad = em.find(GeneralAd.class, ad_id);
			request.setAttribute("genad", genad);
			type = "General";
		}
		
		//calculate price
		Query q = (em.createQuery("SELECT p FROM Price p WHERE p.months = '"+request.getParameter("months")+"' AND p.typ = '"+type+"'"));
		price = ((Price)q.getSingleResult()).getPrice();
		price = price.multiply(BigDecimal.valueOf(Long.valueOf(request.getParameter("months"))));
		
		
		//propose promotions
		Promo promo = (Promo)em.createQuery("SELECT pr FROM Promo pr WHERE pr.name = 'Next with discount' AND pr.valid = 'true'").getSingleResult();
		String username = (String) request.getSession().getAttribute(
				MySQLConnector.USERNAME_OF_CLIENT);
		User user = (User)em
				.createQuery("SELECT d from User d where d.username=:usern")
				.setParameter("usern", username).getSingleResult();
		
		// calculate price according to promotion
		price = price.multiply(BigDecimal.valueOf(Double.valueOf((double)(100-user.getNextPercentDiscount())/100)));

		// delete discount after it has been used
		em.getTransaction().begin();
		if(user.getNextPercentDiscount() > 0){
			request.setAttribute("discount_used", true);
			request.setAttribute("discount_value", user.getNextPercentDiscount());			
			user.setNextPercentDiscount(0);
		}else{ // set discount for the next ad
			request.setAttribute("discount_used", false);
			request.setAttribute("discount_value", promo.getPerc());
			user.setNextPercentDiscount(promo.getPerc());
		}
		em.getTransaction().commit();
		
		request.setAttribute("price", price);
		em.close();
		//redirect to confirmation page		
		request.getRequestDispatcher("/index.jsp?page=showreceipt.jsp").forward(request, response);
	}

}
