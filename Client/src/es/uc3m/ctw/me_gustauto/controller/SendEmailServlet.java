package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.*;
import org.apache.commons.mail.*;

/**
 * Servlet implementation class SendEmailServlet
 */
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendEmailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute(MySQLConnector.USERNAME_OF_CLIENT);
		String body = request.getParameter("message");
		String id = request.getParameter("id");

		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		AutoAd ad = em.find(AutoAd.class, Integer.valueOf(id));
		User vendor = ad.getUser();
		SimpleEmail email = new SimpleEmail();
		try {
			email.setHostName("smtp.gmail.com");
			email.setAuthenticator(new DefaultAuthenticator("projectjava2012",
					"contrasena1234"));
			email.setSmtpPort(587);
			email.setTLS(true);
			email.addTo("projectjava2012@gmail.com", "Project Java");
			email.setFrom("projectjava2012@gmail.com", "someone");
			email.setSubject("Me-gustAUTO Ad nr. " + id + " para "
					+ vendor.getEmail());
			email.setMsg(body);
			email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		em.close();
		request.getRequestDispatcher("/index.jsp?page=showdetails.jsp&id="+id+"&sent=true").include(request, response);
	}
}
