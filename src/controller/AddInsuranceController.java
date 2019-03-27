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

import dao.InsuranceDAO;
import model.Insurance;

@WebServlet("/AddInsuranceController")
public class AddInsuranceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsuranceDAO insdao = new InsuranceDAO();
	
	public AddInsuranceController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addInsurance.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		int type = Integer.parseInt(request.getParameter("type"));
		int exp = Integer.parseInt(request.getParameter("exp"));
		long price = Long.parseLong(request.getParameter("price"));
		int quantityStock = Integer.parseInt(request.getParameter("quantityStock"));
		String forBrand = request.getParameter("forBrand");
		String description = request.getParameter("description");
		
		Insurance ins = new Insurance(name, description, quantityStock, forBrand,type,  exp,
			price);
		try {
			insdao.addIns(ins);
			ArrayList<Insurance> listIns = insdao.getListInsurance();
			request.setAttribute("listIns", listIns);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/listInsurance.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
