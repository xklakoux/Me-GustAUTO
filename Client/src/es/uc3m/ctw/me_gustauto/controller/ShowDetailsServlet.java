package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.ctw.me_gustauto.model.AutoAd;

/**
 * Servlet implementation class ShowAutos
 */
public class ShowDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetailsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		AutoAd auto = em.find(AutoAd.class, id);
		em.close();
		request.setAttribute("auto",auto);
		
		HttpSession session = request.getSession(true);
		Object isLoggedIn = session.getAttribute(MySQLConnector.CLIENT_IS_LOGGED_IN);
		if (isLoggedIn != null && (Boolean) isLoggedIn) {
			boolean favDoesNotExist = MySQLConnector.favDoesNotExist((String) session.getAttribute(MySQLConnector.USERNAME_OF_CLIENT), id);
			request.setAttribute("favDoesNotExist", favDoesNotExist);
		}
		
		request.getRequestDispatcher("/index.jsp?page=showdetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
