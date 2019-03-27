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

@WebServlet("/changeProfile")
public class CustomerChangePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CustomerDAO cusdao = new CustomerDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/changeprocus.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			HttpSession session = request.getSession();
			Customer c = (Customer) session.getAttribute("customer");
			int cmID = c.getCmID();
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			if(!checkPhone(phone)){
				request.setAttribute("error", "Số điện thoại không hợp lệ! (10 số)");
				RequestDispatcher req = request.getRequestDispatcher("WEB-INF/view/changeprocus.jsp");
				req.forward(request, response);
				return;
			}
			cusdao.updateCustomerProfile(name, gender, address, phone, dob, cmID);
			session.removeAttribute("customer");
			Customer cus = cusdao.getCustomerById(cmID);
			session.setAttribute("customer", cus);
			request.setAttribute("changeProfileSuccess", "ok");
			RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/view/profilecus.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean checkPhone(String phone){
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
	
}
