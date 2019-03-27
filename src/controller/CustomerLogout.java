package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class CustomerLogout extends HttpServlet {
	public static final long serialVersionUID = 1L;
	public CustomerLogout(){}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		session.removeAttribute("customer");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
		rd.forward(request, response);
	}
}
