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

import dao.CarDAO;
import model.Car;

/**
 * Servlet implementation class DelCarController
 */
@WebServlet("/DelCarController")
public class DelCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CarDAO cardao = new CarDAO(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int carID = Integer.parseInt(request.getParameter("carID"));
		try {
			cardao.deleteCar(carID);
			ArrayList<Car> listCars = cardao.findAllCar();
			request.setAttribute("cars", listCars);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listCars.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
