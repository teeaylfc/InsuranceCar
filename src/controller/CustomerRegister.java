package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet("/register")
public class CustomerRegister extends HttpServlet {
	public static final long serialVersionUID = 1L;
	private CustomerDAO cusdao = new CustomerDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registercus.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String name = request.getParameter("name");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			if(!checkPhone(phone)){
				request.setAttribute("error", "Số điện thoại không hợp lệ! (10 số)");
				RequestDispatcher req = request.getRequestDispatcher("WEB-INF/view/registercus.jsp");
				req.forward(request, response);
				return;
			}
			else if ((checkAcc(account) >= 0 ) || (checkAcc(password) >= 0 )){
				request.setAttribute("error", "Tài khoản hoặc mật khẩu không được chứa khoảng trắng!");
				RequestDispatcher req = request.getRequestDispatcher("WEB-INF/view/registercus.jsp");
				req.forward(request, response);
				return;
			}
			else if ((cusdao.checkExist(account))){
				request.setAttribute("error", "Tài khoản đã tồn tại!");
				RequestDispatcher req = request.getRequestDispatcher("WEB-INF/view/registercus.jsp");
				req.forward(request, response);
				return;
			}
			Customer c = new Customer(account, password, name, gender, address, phone, dob);
			cusdao.addCustomer(c);
			request.setAttribute("success", "ok");
			RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/view/logincus.jsp");
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
	
	private int checkAcc(String acc){
		return acc.indexOf(" ");
	}
}
