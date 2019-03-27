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

@WebServlet("/addOwnCar")
public class OwnCarAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnCarDAO ocdao = new OwnCarDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addcarcus.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Customer c = (Customer) session.getAttribute("customer");
		int cmID = c.getCmID();
		String brand = request.getParameter("brand");
		String carNumber = request.getParameter("carNumber");
		int numberOfSeat = Integer.parseInt(request.getParameter("numberOfSeat"));
		int haveInsurance = Integer.parseInt(request.getParameter("haveInsurance"));
		OwnCar o = new OwnCar(cmID, haveInsurance, numberOfSeat, carNumber, brand);
		

		try {
			ArrayList<OwnCar> list = ocdao.getListOwnCarByCmID(cmID);
			for(OwnCar oc : list){
				if(carNumber.equals(oc.getCarNumber())){
					request.setAttribute("error", "Xe này đã nhập, không thể thêm lại!");
					RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/view/addcarcus.jsp");
					rq.forward(request, response);
					return;
				}
			}
			if(ocdao.addOwnCar(o)){
				list.add(o);				
				request.setAttribute("listOC", list);
				RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/view/owncarcus.jsp");
				rq.forward(request, response);
			}else{
				request.setAttribute("error", "Thêm xe thất bại!");
				RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/view/addcarcus.jsp");
				rq.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
