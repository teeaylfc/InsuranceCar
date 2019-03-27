package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InsuranceDAO;
import model.Insurance;

@WebServlet("/ForwardUpdateInsurance")
public class ForwardUpdateInsurance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsuranceDAO insdao = new InsuranceDAO();
	
	public ForwardUpdateInsurance(){
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("insuranceID"));
		try {
			Insurance ins = insdao.findInsuranceById(id);
			request.setAttribute("ins", ins);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/EditInsurance.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
