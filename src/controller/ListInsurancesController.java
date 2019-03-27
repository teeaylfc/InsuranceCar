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
import javax.servlet.http.HttpSession;

import model.Insurance;
import dao.InsuranceDAO;

@WebServlet("/ListInsurancesController")
public class ListInsurancesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InsuranceDAO insdao = new InsuranceDAO();
	
	
	public ListInsurancesController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
		ArrayList<Insurance> listIns;
		try {
			listIns = insdao.getListInsurance();
			request.setAttribute("listIns", listIns);
			 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listInsurance.jsp");
			 rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
