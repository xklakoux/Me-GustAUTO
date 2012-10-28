package es.uc3m.ctw.me_gustauto;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).setAttribute(
				MySQLConnector.CLIENT_IS_LOGGED_IN, false);
		request.getSession(true).setAttribute(
				MySQLConnector.USERNAME_OF_CLIENT, null);
		request.getSession(true).setAttribute(MySQLConnector.IS_ADMIN,false);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (MySQLConnector.verifyLogin(username, password)) {
			request.getSession(true).setAttribute(
					MySQLConnector.CLIENT_IS_LOGGED_IN, true);
			request.getSession(true).setAttribute(
					MySQLConnector.USERNAME_OF_CLIENT, username);
			request.getSession(true).setAttribute(MySQLConnector.IS_ADMIN,
					MySQLConnector.verifyAdmin(username));
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
