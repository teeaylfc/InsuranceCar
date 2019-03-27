package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import model.Customer;

@WebServlet("/changePassword")
public class CustomerChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CustomerDAO cusdao = new CustomerDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/changepasscus.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			HttpSession session = request.getSession();
			Customer c = (Customer) session.getAttribute("customer");
			int cmID = c.getCmID();
			String oldpass = request.getParameter("oldpassword");
			String newpass = request.getParameter("newpassword");
			boolean success = cusdao.updateCustomerPassword(oldpass, newpass, cmID);
			if(success){
				session.removeAttribute("customer");
				Customer cus = cusdao.getCustomerById(cmID);
				session.setAttribute("customer", cus);
				request.setAttribute("changePassSuccess", "ok");
				RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/view/profilecus.jsp");
				req.forward(request, response);
			}
			else {
				request.setAttribute("changePassFail", "ok");
				RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/view/changepasscus.jsp");
				req.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
