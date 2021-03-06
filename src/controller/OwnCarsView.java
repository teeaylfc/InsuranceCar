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

import dao.OwnCarDAO;
import model.Customer;
import model.OwnCar;

@WebServlet("/myOwnCars")
public class OwnCarsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnCarDAO ocdao = new OwnCarDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		Customer c = (Customer) session.getAttribute("customer");
		int cmID = c.getCmID();
		ArrayList<OwnCar> list;
		try {
			list = ocdao.getListOwnCarByCmID(cmID);
			request.setAttribute("listOC", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/owncarcus.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
