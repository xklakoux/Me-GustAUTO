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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String title = "'" + request.getParameter("title") + "'";
		if (title.length() == 2) title = "a.title";
		
		String brand = "'" + request.getParameter("brand") + "'";
		if (brand.length() == 3) brand = "a.brand";
		
		String model = "'" + request.getParameter("model") + "'";
		if (model.length() == 3) model = "a.model";
		
		String engine = "'" + request.getParameter("engine") + "'";
		if (engine.length() == 3) engine = "a.engine";
		
		String colour = "'" + request.getParameter("colour") + "'";
		if (colour.length() == 3) colour = "a.colour";
		
		
		
		String priceFrom = request.getParameter("priceFrom");
		if (priceFrom.length() == 0) priceFrom = "0";
		
		String priceTo = request.getParameter("priceTo");
		if (priceTo.length() == 0) priceTo = "999999";
		
		String mileageFrom = request.getParameter("mileageFrom");
		if (mileageFrom.length() == 0) mileageFrom = "0";
		
		String mileageTo = request.getParameter("mileageTo");
		if (mileageTo.length() == 0) mileageTo = "999999";
		
		String yearFrom = request.getParameter("yearFrom");
		if (yearFrom.length() == 0) yearFrom = "0";
		
		String yearTo = request.getParameter("yearTo");
		if (yearTo.length() == 0) yearTo = "9999";
		
		
		
		List<?> list = MySQLConnector.getFactory().createEntityManager()
				.createQuery("SELECT a FROM AutoAd a " +
						"WHERE a.title = " + title +
						" AND a.brand = " + brand +
						" AND a.model = " + model +
						" AND a.engine = " + engine +
						" AND a.colour = " + colour +
						
						" AND a.price >= " + priceFrom +
						" AND a.price <= " + priceTo +
						
						" AND a.mileage >= " + mileageFrom +
						" AND a.mileage <= " + mileageTo +
						
						" AND a.years >= " + yearFrom +
						" AND a.years <= " + yearTo
						).getResultList();
		
		request.setAttribute("SEARCHRESULT", true);
		request.setAttribute("LIST", list);
		
		request.getRequestDispatcher("index.jsp").include(request, response);
	}
}
