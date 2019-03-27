
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Insurance;
import dao.InsuranceDAO;

/**
 * Servlet implementation class InsurancePageController
 */
@WebServlet("/insurancePage")
public class InsurancePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InsuranceDAO insdao = new InsuranceDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsurancePageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ArrayList<Insurance> listIns;
			try {
				listIns = insdao.getListInsurance();
				request.setAttribute("ins", listIns);
				 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/insurancePage.jsp");
				 rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
