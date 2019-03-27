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

import dao.InsuranceDAO;
import model.Insurance;

@WebServlet("/DeleteInsuranceController")
public class DeleteInsuranceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsuranceDAO insdao = new InsuranceDAO();
	
	public DeleteInsuranceController(){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("insuranceID"));
		
		try {
			insdao.deleteIns(id);
			ArrayList<Insurance> listIns = insdao.getListInsurance();
			request.setAttribute("listIns", listIns);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/listInsurance.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
