package es.uc3m.ctw.me_gustauto;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext context = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		
		if (username.length() != 0 && password1.length() != 0) {
			StringBuilder salt = new StringBuilder();
			for (int i=0; i<MySQLConnector.SALTLENGTH; i++) {
				salt.append((char) (Math.random()*25.0 + 65));
			}
			
			String query = "INSERT INTO users (username,full_name,hash,salt,email) VALUES ('" + username + "','matt','"
			+ MySQLConnector.sha1(password1, salt.toString())+ "','" + salt.toString() + "','bla');";
			System.out.println(query);
			MySQLConnector.execute(query);
			
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("registration_form.jsp");
		}
	}

}
