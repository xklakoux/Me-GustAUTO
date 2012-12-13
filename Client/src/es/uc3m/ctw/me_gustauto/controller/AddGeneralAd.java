package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.GeneralAd;
import es.uc3m.ctw.me_gustauto.model.User;

/**
 * Servlet implementation class AddGeneralAd
 */
public class AddGeneralAd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGeneralAd() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date add_Date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(add_Date);
		cal.add(Calendar.MONTH, Integer.valueOf(request.getParameter("months"))); // add months to add_date
		Date valid_To = cal.getTime();
		
		GeneralAd ga = new GeneralAd();
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		String username = (String) request.getSession().getAttribute(MySQLConnector.USERNAME_OF_CLIENT);
		User user = (User) em.createQuery("SELECT u FROM User u WHERE u.username = :usern").setParameter("usern", username).getSingleResult();
		em.getTransaction().begin();
		em.persist(ga);
		ga.setTitle((String) request.getParameter("title"));
		ga.setDescr((String) request.getParameter("descr"));
		ga.setUser(user);
		ga.setAddDate(add_Date);
		ga.setValidTo(valid_To);
		ga.setMonths(Integer.valueOf(request.getParameter("months")));
		em.getTransaction().commit();
		em.close();
		response.sendRedirect("PaymentReceipt?id="+ga.getAdId()+"&months="+request.getParameter("months")+"&ad_type=genad");
		return;
	}
}
