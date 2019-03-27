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


import dao.CarDAO;
import model.Car;

/**
 * Servlet implementation class ShowCarHome
 */
@WebServlet("/showcarhome")
public class ShowCarHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CarDAO cardao = new CarDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<Car> listCars;
		try {
			listCars = cardao.findAllCar();
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
