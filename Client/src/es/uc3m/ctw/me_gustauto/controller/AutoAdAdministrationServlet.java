package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String ad_id = request.getParameter("ad_id");
		if ("c".equals(command)) {
			MySQLConnector.executeUpdate("UPDATE AutoAd a SET a.validTo = :validTo WHERE a.adId = '" + ad_id + "'", "validTo", new Date());
		} else if ("d".equals(command)) {
			MySQLConnector.executeUpdate("DELETE FROM AutoAd a WHERE a.adId = :adId", "adId", Integer.parseInt(ad_id));
		}
		response.sendRedirect("index.jsp");
	}
}
