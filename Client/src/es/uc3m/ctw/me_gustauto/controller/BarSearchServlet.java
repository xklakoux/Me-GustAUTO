package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BarSearchServlet
 */
@WebServlet("/BarSearchServlet")
public class BarSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarSearchServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (context.getAttribute("SearchBrand") == null) context.setAttribute("SearchBrand", AutoAdListBean.getList("brand"));
		if (context.getAttribute("SearchModel") == null) context.setAttribute("SearchModel", AutoAdListBean.getList("model"));
		if (context.getAttribute("SearchEngine") == null) context.setAttribute("SearchEngine", AutoAdListBean.getList("engine"));
		if (context.getAttribute("SearchColour") == null) context.setAttribute("SearchColour", AutoAdListBean.getList("colour"));
		request.getRequestDispatcher("bar-search.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
