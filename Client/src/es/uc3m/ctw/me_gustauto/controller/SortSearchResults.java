package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SortSearchResults
 */
@WebServlet("/SortSearchResults")
public class SortSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SortSearchResults() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String squery = request.getParameter("query") + " ORDER BY a." + request.getParameter("field") + " " + request.getParameter("order");
		
		List<?> list = MySQLConnector.getFactory().createEntityManager()
				.createQuery(squery).getResultList();
		
		request.setAttribute("SEARCH_QUERY", request.getParameter("query"));
		request.setAttribute("SEARCHRESULT", true);
		request.setAttribute("LIST", list);
		
		request.getRequestDispatcher("index.jsp").include(request, response);
	}

}
