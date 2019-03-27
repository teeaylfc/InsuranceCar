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

import dao.CustomerDAO;
import model.Customer;
import model.RegisterInsurance;

@WebServlet("/customers")
public class ListCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO cusDAO = new CustomerDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
		ArrayList<Customer> list;
		try {
			list = cusDAO.getAllCustomer();
			request.setAttribute("listCus", list);
			 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listcustomer.jsp");
			 rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int cmID = Integer.parseInt(request.getParameter("cmID"));
		ArrayList<Customer> list;
		switch(action){
			case "delete": {
				try {
					cusDAO.deleteCustomer(cmID);
					list = cusDAO.getAllCustomer();
					request.setAttribute("listCus", list);
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listcustomer.jsp");
					rd.forward(request, response);
					break;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}
