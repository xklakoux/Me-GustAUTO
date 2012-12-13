package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("megustauto");
		EntityManager em = emf.createEntityManager();
		String username = (String) request.getSession().getAttribute(
				MySQLConnector.USERNAME_OF_CLIENT);
		System.out.println("username " + username);
		User user = (User) em
				.createQuery("SELECT d from User d where d.username=:usern")
				.setParameter("usern", username).getResultList().get(0);
		List<Message> messages = (List<Message>) em
				.createQuery("SELECT d from Message d where d.user2=:usern")
				.setParameter("usern", user).getResultList();
		em.close();
		if (!messages.isEmpty()) {
			request.setAttribute("messages", messages);
		}
		// System.out.println(messages.get(0).getContent());
		request.getRequestDispatcher("/index.jsp?page=messages.jsp").forward(
				request, response);

		final String FACTORY = "jms/ConnectionFactory";
		final String QUEUE = "jms/Queue";
		boolean stop=false;
		try {
			// Prompt for JNDI names
			// Look up administered objects
			InitialContext initContext = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) initContext
					.lookup(FACTORY);
			Queue queue = (Queue) initContext.lookup(QUEUE);
			initContext.close();
			// Create JMS objects
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver = session.createReceiver(queue);
			receiver.receive();
			connection.start();
			// Wait for stop
			while (!stop) {
				Thread.sleep(1000);
			}
			// Exit
			System.out.println("Exiting...");
			connection.close();
			System.out.println("Goodbye!");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
