package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
	private ServletContext context;

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
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context.setAttribute("AutoAdList", null);
		
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		if ("c".equals(command)) {
			em.getTransaction().begin();
			AutoAd autoAd = em.find(AutoAd.class, Integer.parseInt(id));
			autoAd.setValidTo(new Date());
			em.getTransaction().commit();
			response.sendRedirect("index.jsp");
		} else if ("d".equals(command)) {
			em.getTransaction().begin();
			AutoAd autoAd = em.find(AutoAd.class, Integer.parseInt(id));
			em.remove(autoAd);
			em.getTransaction().commit();
			response.sendRedirect("index.jsp");
		} else if ("af".equals(command)) {
			Object o = em.createQuery("SELECT u FROM User u WHERE u.username = '" + request.getSession(true).getAttribute(MySQLConnector.USERNAME_OF_CLIENT) + "'").getResultList().get(0);
			User user = (User) MySQLConnector.createDeepCopy(o);
			AutoAd autoAd = em.find(AutoAd.class, Integer.parseInt(id));
			
			if (MySQLConnector.favDoesNotExist(user.getUsername(), autoAd.getAdId())) {
				em.getTransaction().begin();
				Fav f = new Fav();
				em.persist(f);
				f.setUser(user);
				f.setAutoAd(autoAd);
				em.getTransaction().commit();
			}
			response.sendRedirect("index.jsp");
		} else if ("df".equals(command)) {
			em.getTransaction().begin();
			Fav fav = em.find(Fav.class, Integer.parseInt(id));
			em.remove(fav);
			em.getTransaction().commit();
			response.sendRedirect("index.jsp?page=showfav.jsp");
		}
		em.close();
	}
}
