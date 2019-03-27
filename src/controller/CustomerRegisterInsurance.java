package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.tools.javac.util.RichDiagnosticFormatter;

import dao.InsuranceDAO;
import dao.OwnCarDAO;
import dao.RegisterInsuranceDAO;
import model.Insurance;
import model.OwnCar;
import model.RegisterInsurance;

@WebServlet("/registerInsurance")
public class CustomerRegisterInsurance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsuranceDAO insDAO = new InsuranceDAO();
	private OwnCarDAO ocDAO = new OwnCarDAO();
	private RegisterInsuranceDAO riDAO = new RegisterInsuranceDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("registerInsuranceID", request.getParameter("insuranceID")+"");
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		int id = Integer.parseInt((String)session.getAttribute("registerInsuranceID"));
		
		try {
			Insurance ins = insDAO.findInsuranceById(id);
			request.setAttribute("ins", ins);
			ArrayList<OwnCar> listOC = ocDAO.getListOwnCarByBrand(ins.getForBrand());
			request.setAttribute("listOC", listOC);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/buycus.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String carNumber = request.getParameter("ownCar");
		int insuranceID = Integer.parseInt(request.getParameter("insuranceID"));
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String registeredDate = dateFormat.format(date);
		int cmID = Integer.parseInt(request.getParameter("customerID"));
		riDAO.addRegisterInsurance(carNumber, insuranceID, registeredDate, cmID);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/listRegisteredInsurance.jsp");
		rd.forward(request, response);
	}
	
}
