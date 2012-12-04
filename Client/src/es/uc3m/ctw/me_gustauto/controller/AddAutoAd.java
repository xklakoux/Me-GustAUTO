package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.AutoAd;
import es.uc3m.ctw.me_gustauto.model.User;

/**
 * Servlet implementation class AddAutoAd
 */
@WebServlet("/AddAutoAd")
public class AddAutoAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
       
    public AddAutoAd() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
		context = config.getServletContext();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date add_Date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(add_Date);
		cal.add(Calendar.MONTH, Integer.valueOf(request.getParameter("months"))); // add months to add_date
		Date valid_To = cal.getTime();
		
//		SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");			
		
		
		String username = (String) request.getSession().getAttribute(MySQLConnector.USERNAME_OF_CLIENT);
	
		AutoAd ad = new AutoAd();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("megustauto");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction(); 
		
		Object u = (em.createQuery("SELECT c FROM User c WHERE c.username=:userName")
				.setParameter("userName", username).getResultList().get(0));
		
		
		et.begin();
		em.persist(ad);		
		
		
		ad.setAddDate(add_Date);
		ad.setValidTo(valid_To);
		ad.setAutoMoto(request.getParameter("auto_moto"));
		ad.setBrand(request.getParameter("brand"));
		ad.setColour(request.getParameter("colour"));
		ad.setDescription(request.getParameter("description"));
		ad.setEngine(request.getParameter("engine"));
		ad.setMileage(Integer.valueOf(request.getParameter("mileage")));
		ad.setModel(request.getParameter("model"));
		ad.setPrice(BigDecimal.valueOf(Double.valueOf(request.getParameter("price"))));
		ad.setRegistrationNumber(request.getParameter("registration_number"));
		ad.setYears(request.getParameter("years"));
		ad.setTitle(request.getParameter("title"));
		ad.setUser((User) u);	
		ad.setValid(false);
		ad.setPaid(false);
		
		et.commit();
		
		String ad_id = String.valueOf(ad.getAdId());
		
		em.close();
		
				
		// delete search option values in context
		context.setAttribute("SearchBrand", null);
		context.setAttribute("SearchModel", null);
		context.setAttribute("SearchEngine", null);
		context.setAttribute("SearchColour", null);
		context.setAttribute("AutoAdList", null);

		response.sendRedirect("PaymentReceipt?id="+ad_id+"&months="+request.getParameter("months"));
		//TODO: show only valid and paid ads on the page
		//response.sendRedirect("ShowAutos?id="+ad_id);
	}

}
