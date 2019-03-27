package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import dao.InsuranceDAO;
import model.Customer;
import model.Insurance;




@WebServlet("/login")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO cusdao = new CustomerDAO();
	private InsuranceDAO insDAO = new InsuranceDAO();
	public CustomerLogin(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		// đăng nhập bằng cách vào trang login
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profilecus.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Customer c = cusdao.checkLogin(account, password);
		
		if(c!=null){
			session.setAttribute("customer", c);
			// đăng nhập từ link khác chuyển tới
			checkForward(session, request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profilecus.jsp");
			rd.forward(request, response);
			return;
		}
		request.setAttribute("error", "Tài khoản hoặc Mật khẩu không đúng!");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/logincus.jsp");
		rd.forward(request, response);
		return;
	}
	
	public void checkForward(HttpSession session , HttpServletRequest request, HttpServletResponse response ){
		
		try {
			if(session.getAttribute("registerInsuranceID")!=null){
				int id = Integer.parseInt((String)session.getAttribute("registerInsuranceID"));
				session.removeAttribute("registerInsuranceID");
				Insurance ins;
				ins = insDAO.findInsuranceById(id);
				request.setAttribute("ins", ins);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/buycus.jsp");
				rd.forward(request, response);
				return;
			}
			
		} catch (IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
}
