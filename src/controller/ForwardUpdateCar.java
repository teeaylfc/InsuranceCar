package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CarDAO;
import model.Car;

@WebServlet("/ForwardUpdateCar")
@MultipartConfig
public class ForwardUpdateCar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static CarDAO cardao = new CarDAO();
	
	private static final String UPLOAD_DIRECTORY = "images";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	public ForwardUpdateCar() {
		super();
		    // TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminAccount")==null){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin_login.jsp");
			rd.forward(request, response);
			return;
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int carID = Integer.parseInt(request.getParameter("carID"));
		Car car = new Car();
		try {
			car = cardao.findCarById(carID);
			request.setAttribute("car", car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateCar.jsp");
		rd.forward(request, response);
	}
	
}
