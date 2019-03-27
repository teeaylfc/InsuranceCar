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

import dao.AdminDAO;
import model.Admin;


@WebServlet("/adminLogin")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO addao = new AdminDAO();
	
	public login(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		String adminAccount = request.getParameter("adminAccount");
		String adminPassword = request.getParameter("adminPassword");
		ArrayList<Admin> listAdmin;
		int check = 0;
		try {
			listAdmin = addao.findAllAdmin();
			for(Admin ad : listAdmin){
				String adAccount = ad.getAccount();
				String adPass = ad.getPassword();
				if(adAccount.equals(adminAccount) && adPass.equals(adminPassword)){
					session.setAttribute("adminAccount", adAccount);
					session.setAttribute("adminPassword", adPass);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
					rd.forward(request, response);
					check = 1;
					return;
				}
			}
			request.setAttribute("error", "Tài khoản hoặc Mật khẩu không đúng!");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
