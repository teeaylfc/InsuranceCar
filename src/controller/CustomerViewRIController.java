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
import model.Customer;
import model.RegisterInsurance;

@WebServlet("/myInsurance")
public class CustomerViewRIController extends HttpServlet {
	private static final long serialVersionUID=  1L;
	private RegisterInsuranceDAO riDAO = new RegisterInsuranceDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		 ArrayList<RegisterInsurance> list;
		 Customer c = (Customer) session.getAttribute("customer");
		list = riDAO.getAllRegisteredInsurancesByCmID(c.getCmID());
		request.setAttribute("listRI", list);
		 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listRegisteredInsurance.jsp");
		 rd.forward(request, response); 
	}
}
