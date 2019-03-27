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

import model.Car;
import model.Insurance;
import dao.CarDAO;
import dao.InsuranceDAO;

/**
 * Servlet implementation class homeforward
 */
@WebServlet("/homeforward")
public class homeforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CarDAO cardao = new CarDAO();
	public InsuranceDAO insdao = new InsuranceDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ArrayList<Car> listCars;
		 ArrayList<Insurance> listIns;
			try {
				listIns = insdao.getListInsurance();
				listCars = cardao.findAllCar();
				request.setAttribute("ins", listIns);
				request.setAttribute("cars", listCars);
				 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/home.jsp");
				 rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
