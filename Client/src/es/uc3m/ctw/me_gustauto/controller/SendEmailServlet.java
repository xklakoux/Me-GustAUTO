package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.Date;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.AutoAd;
import es.uc3m.ctw.me_gustauto.model.Message;
import es.uc3m.ctw.me_gustauto.model.User;

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
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = (String) request.getSession().getAttribute(
				MySQLConnector.USERNAME_OF_CLIENT);

		final String FACTORY = "jms/ConnectionFactory";
		final String QUEUE = "jms/Queue";
		try {
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
			QueueSender sender = session.createSender(queue);
			// Send messages
			String messageText = null;
			messageText = (String) request.getParameter("message");
			TextMessage message = session.createTextMessage(messageText);
			message.setStringProperty("username", username);
			message.setIntProperty("idAd", Integer.valueOf(id));
			
			sender.send(message);
			// Exit
			System.out.println("Exiting...");
			connection.close();
			System.out.println("Goodbye!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(
				"AutoAdAdministrationServlet?command=c&id=" + id + "&sent=true")
				.include(request, response);
	}
}
