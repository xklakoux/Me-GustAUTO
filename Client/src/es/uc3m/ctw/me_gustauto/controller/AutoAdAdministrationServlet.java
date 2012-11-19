package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.AutoAd;
import es.uc3m.ctw.me_gustauto.model.Fav;
import es.uc3m.ctw.me_gustauto.model.User;

/**
 * Servlet implementation class AutoAdAdministrationServlet
 */
@WebServlet("/AutoAdAdministrationServlet")
public class AutoAdAdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoAdAdministrationServlet() {
        super();
    }

    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		if ("c".equals(command)) {
			MySQLConnector.executeUpdate("UPDATE AutoAd a SET a.validTo = :validTo WHERE a.adId = " + id, "validTo", new Date());
			response.sendRedirect("index.jsp");
		} else if ("d".equals(command)) {
			MySQLConnector.executeUpdate("DELETE FROM AutoAd a WHERE a.adId = :id", "id", Integer.parseInt(id));
			response.sendRedirect("index.jsp");
		} else if ("af".equals(command)) {
			User user = (User) MySQLConnector.executeQuery("SELECT u FROM User u WHERE u.username = '" + request.getSession(true).getAttribute(MySQLConnector.USERNAME_OF_CLIENT) + "'").get(0);
			AutoAd autoAd = (AutoAd) MySQLConnector.executeQuery("SELECT a FROM AutoAd a WHERE a.adId = " + id).get(0);
			
			if (MySQLConnector.favDoesNotExist(user.getUsername(), autoAd.getAdId())) {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory(MySQLConnector.PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				
				Fav f = new Fav();
				em.persist(f);
				f.setUser(user);
				f.setAutoAd(autoAd);
				
				tx.commit();
				em.close();
			}
			response.sendRedirect("index.jsp");
		} else if ("df".equals(command)) {
			MySQLConnector.executeUpdate("DELETE FROM Fav v WHERE v.id = :id", "id", Integer.parseInt(id));
			response.sendRedirect("index.jsp?page=showfav.jsp");
		}
	}
}
