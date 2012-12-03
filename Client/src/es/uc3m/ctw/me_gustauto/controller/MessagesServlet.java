package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import es.uc3m.ctw.me_gustauto.model.AutoAd;
import es.uc3m.ctw.me_gustauto.model.Message;
import es.uc3m.ctw.me_gustauto.model.User;

/**
 * Servlet implementation class MessagesServlet
 */
public class MessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("megustauto");
		EntityManager em = emf.createEntityManager();
		String username = (String) request.getSession().getAttribute(MySQLConnector.USERNAME_OF_CLIENT);
		System.out.println("username " + username);
		User user = (User) em.createQuery("SELECT d from User d where d.username=:usern").setParameter("usern", username).getResultList().get(0);
		List<Message> messages = (List<Message>) em.createQuery("SELECT d from Message d where d.user2=:usern").setParameter("usern", user).getResultList();
		request.setAttribute("messages", messages);
		System.out.println(messages.get(0).getContent());
		request.getRequestDispatcher("/index.jsp?page=messages.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
