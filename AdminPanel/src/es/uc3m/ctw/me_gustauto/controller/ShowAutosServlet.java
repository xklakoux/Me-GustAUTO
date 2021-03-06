package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAutosServlet
 */
@WebServlet("/ShowAutosServlet")
public class ShowAutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAutosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<?> list;
		
		EntityManager em = Persistence.createEntityManagerFactory("megustauto").createEntityManager();

		String jpql;
		
		if(request.getParameter("list_type") == null || request.getParameter("list_type").equals("0") ){
			jpql = "SELECT c FROM AutoAd c WHERE c.valid ='0'";
		}else{
			jpql = "SELECT c FROM AutoAd c";
		}
		
		Query query = em.createQuery(jpql); 
		list = query.getResultList();
		
		em.close();
		
		request.setAttribute("list", list);		
		
		request.getRequestDispatcher("index.jsp?page=showautos.jsp").include(request, response);
	}

}