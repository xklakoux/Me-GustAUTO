package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SortSearchResults() {
        super();
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String squery = request.getParameter("query") + " ORDER BY a." + request.getParameter("field") + " " + request.getParameter("order");
		
		List<?> list = Persistence.createEntityManagerFactory("megustauto").createEntityManager()
				.createQuery(squery).getResultList();
		
		request.setAttribute("SEARCH_QUERY", request.getParameter("query"));
		request.setAttribute("SEARCHRESULT", true);
		request.setAttribute("LIST", list);
		
		request.getRequestDispatcher("index.jsp").include(request, response);
	}
}
