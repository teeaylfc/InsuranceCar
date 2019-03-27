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

import dao.RegisterInsuranceDAO;
import model.RegisterInsurance;

@WebServlet("/manageRegisterInsurances")
public class ListRegisterInsurancesController extends HttpServlet {
	private static final long serialVerionUID = 1L;
	private RegisterInsuranceDAO riDAO = new RegisterInsuranceDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
		ArrayList<RegisterInsurance> list;
		String query = request.getParameter("status");
		switch(query){
			case "pending": {
				list = riDAO.getAllPendingInsurances();
				request.setAttribute("listPI", list);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/BHchoKichhoat.jsp");
				rd.forward(request, response);
				break;
			}
			case "registered": {
				list = riDAO.getAllRegisteredInsurances();
				request.setAttribute("listRI", list);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/BHdaKichhoat.jsp");
				rd.forward(request, response);
				break;
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int riID = Integer.parseInt(request.getParameter("riID"));
		ArrayList<RegisterInsurance> list;
		switch(action){
			case "destroy": {
				riDAO.rejectRegisterInsurance(riID);
				list = riDAO.getAllRegisteredInsurances();
				request.setAttribute("listRI", list);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/BHdaKichhoat.jsp");
				rd.forward(request, response);
				break;
			}
			case "active": {
				riDAO.acceptRegisterInsurance(riID);
				System.out.println("Da goi ham acceptRegister");
				list = riDAO.getAllRegisteredInsurances();
				request.setAttribute("listRI", list);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/BHdaKichhoat.jsp");
				rd.forward(request, response);
				break;
			}
		}
	}
	
}
