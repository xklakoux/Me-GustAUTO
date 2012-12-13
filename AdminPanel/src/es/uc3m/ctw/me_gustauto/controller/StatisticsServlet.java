package es.uc3m.ctw.me_gustauto.controller;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.ctw.me_gustauto.ejb.StatisticsRemote;

/**
 * Servlet implementation class StatisticsServlet
 */
@WebServlet("/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsServlet() {
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
		int autoAdsCount = -1;
		int generalAdsCount = -1;
		double totalIncome = -1;
		try {
	        InitialContext context = new InitialContext();
	        StatisticsRemote bean = (StatisticsRemote) context.lookup("es.uc3m.ctw.me_gustauto.ejb.StatisticsRemote");
	        autoAdsCount = bean.getAutoAdsCount();
	        generalAdsCount = bean.getGeneralAdsCount();
	        totalIncome = bean.getTotalIncome();
	    } catch(Exception e) {
	       	e.printStackTrace();
	    }
		request.setAttribute("AutoAdsCount", autoAdsCount);
		request.setAttribute("GeneralAdsCount", generalAdsCount);
		request.setAttribute("TotalIncome", totalIncome);
		request.getRequestDispatcher("/index.jsp?page=statistics.jsp").include(request, response);
	}

}
