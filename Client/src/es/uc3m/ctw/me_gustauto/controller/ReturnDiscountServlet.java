package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.model.User;

/**
 * Servlet implementation class ReturnDiscountServlet
 * 
 * CALLED WHEN USER CANCELS A TRANSACTION
 * 
 */
@WebServlet("/ReturnDiscountServlet")
public class ReturnDiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnDiscountServlet() {
        super();
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
		EntityManager em = MySQLConnector.getFactory().createEntityManager();
		String username = (String) request.getSession().getAttribute(
				MySQLConnector.USERNAME_OF_CLIENT);
		User user = (User)em
				.createQuery("SELECT d from User d where d.username=:usern")
				.setParameter("usern", username).getSingleResult();
		
		em.getTransaction().begin();
		if(!request.getParameter("discount_value").matches("\\d*")){
			user.setNextPercentDiscount(0);
		}else{			
			user.setNextPercentDiscount(Integer.valueOf(request.getParameter("discount_value")));			
		}
		em.getTransaction().commit();
		em.close();
		response.sendRedirect("index.jsp");
		// should it delete the ad from db ?
	}

}
