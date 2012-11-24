package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GeneralAd ga = new GeneralAd();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("megustauto");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction et = manager.getTransaction();
		String username = (String) request.getSession().getAttribute(
				MySQLConnector.USERNAME_OF_CLIENT);
		User user = new User();
		user = (User) manager.createNamedQuery("getUserByUsername")
				.setParameter("usern", username).getResultList().get(0);

		et.begin();
		manager.persist(ga);
		ga.setTitle((String) request.getParameter("title"));
		ga.setDescr((String) request.getParameter("descr"));
		ga.setUser(user);
		ga.setAddDate(new Date());
		et.commit();
		response.sendRedirect("index.jsp?page=success.jsp");
		return;
	}
}
