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

@WebServlet("/editOwnCar")
public class OwnCarUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnCarDAO ocdao = new OwnCarDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("customer")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/logincus.jsp");
			rd.forward(request, response);
			return;
		}
		if(request.getParameter("owncarID")!=null){
			OwnCar o;
			try {
				o = ocdao.getOwnCarByOwnCarID(Integer.parseInt(request.getParameter("owncarID")));
				request.setAttribute("oc", o);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/editOwnCar.jsp");
				rd.forward(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Customer c = (Customer) session.getAttribute("customer");
		int cmID = c.getCmID();
		String brand = request.getParameter("brand");
		String carNumber = request.getParameter("carNumber");
		String defaultCarNumber = request.getParameter("defaultCarNumber");
		int owncarID = Integer.parseInt(request.getParameter("owncarID")); 
		int numberOfSeat = Integer.parseInt(request.getParameter("numberOfSeat"));
		int haveInsurance = Integer.parseInt(request.getParameter("haveInsurance"));
		OwnCar o = new OwnCar(cmID, haveInsurance, numberOfSeat, carNumber, brand);
		

		try {
			ArrayList<OwnCar> list = ocdao.getListOwnCarByCmID(cmID);
			for(OwnCar oc : list){
				if((carNumber.equals(oc.getCarNumber())) && (!defaultCarNumber.equals(oc.getCarNumber()))){
					request.setAttribute("error", "Biển số xe đã tồn tại, hãy ra chọn đúng xe để update!");
					RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/view/addcarcus.jsp");
					rq.forward(request, response);
					return;
				}
			}
			
			if(ocdao.updateOwnCar(carNumber, numberOfSeat, haveInsurance, brand, owncarID)){
				ArrayList<OwnCar> updatedList = ocdao.getListOwnCarByCmID(cmID);
				request.setAttribute("listOC", updatedList);
				RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/view/owncarcus.jsp");
				rq.forward(request, response);
			}else{
				request.setAttribute("error", "Sửa thông tin xe thất bại!");
				RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/view/editOwnCar.jsp");
				rq.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
