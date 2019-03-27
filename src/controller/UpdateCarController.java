package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.CarDAO;
import model.Car;

@WebServlet("/UpdateCarController")
@MultipartConfig
public class UpdateCarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static CarDAO cardao = new CarDAO();
	
	private static final String UPLOAD_DIRECTORY = "images";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	public UpdateCarController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addCar.jsp");
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int carID = Integer.parseInt(request.getParameter("carID"));
		String name = request.getParameter("nameCar").toString();
		int nsx = Integer.parseInt(request.getParameter("productDate"));
		long price = Long.parseLong(request.getParameter("price"));
		int quantityStock = Integer.parseInt(request.getParameter("quantityStock"));
		String description = request.getParameter("description").toString();
		String brand = request.getParameter("brand").toString();
		String imageCar = "";
		String fileName = request.getParameter("photo");
			 DiskFileItemFactory factory = new DiskFileItemFactory();
				// sets memory threshold - beyond which files are stored in disk
				factory.setSizeThreshold(MEMORY_THRESHOLD);
				// sets temporary location to store files
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
				ServletFileUpload upload = new ServletFileUpload(factory);
		
				// sets maximum size of upload file
				upload.setFileSizeMax(MAX_FILE_SIZE);
		
				// sets maximum size of request (include file + form data)
				upload.setSizeMax(MAX_REQUEST_SIZE);
		
				// constructs the directory path to store upload file
				// this path is relative to application's directory
			

				try{
					List<Part> fileParts = request.getParts().stream().filter(part -> "photo".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
		    		String uploadPath = "C:\\Users\\AnhXtanh\\workspace\\hungptit\\WebContent\\" + UPLOAD_DIRECTORY;
		    		File uploadDir = new File(uploadPath);
		    		if (!uploadDir.exists()) {
						uploadDir.mkdir();
					}
		    		for (Part filePart : fileParts) {
				        imageCar = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				        System.out.println(imageCar);
				        String filePath = uploadPath + File.separator + imageCar;
				        filePart.write(uploadPath);
				    } 
				}catch(Exception ex){
					request.setAttribute("message", "There was an error: " + ex.getMessage());
				}
				if (imageCar.equals("")) {
					Car car = new Car (name, description, brand, nsx, price, quantityStock);
					try {
						cardao.updateCarNoneImage(car, carID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					Car car = new Car (name, description, brand, nsx, price, quantityStock, imageCar);
					try {
						cardao.updateCar(car, carID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ArrayList<Car> listCar;
				try {
					listCar = cardao.findAllCar();
					request.setAttribute("cars", listCar);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/listCars.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
}
