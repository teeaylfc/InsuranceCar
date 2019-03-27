package dao;

import java.sql.*;
import java.util.ArrayList;


import connect.DBConnect;
import model.Car;

public class CarDAO {
	
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public boolean addCar(Car car) throws SQLException {
		String query = "INSERT INTO car (name, productDate, price, quantityStock, description, brand, imageCar) VALUES (?, ?, ?, ? , ? ,?,?)";
		PreparedStatement statement = getConnection().prepareStatement(query);
		statement.setString(1, car.getName());
		statement.setInt(2, car.getProductDate());
		statement.setLong(3, car.getPrice());
		statement.setInt(4, car.getQuantityStock());
		statement.setString(5, car.getDescription());
		statement.setString(6, car.getBrand());
		statement.setString(7, car.getImageCar());
		int result = statement.executeUpdate();
		if (result != 0) {
			return true;
		} else {
			return false;
		}		
	}
	
	public ArrayList<Car> findAllCar() throws SQLException{
		String query = "SELECT * FROM car";
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Car> listCar = new ArrayList<Car>();
		while(rs.next()) {
			Car car = new Car();
			car.setCarID(rs.getInt("carID"));
			car.setName(rs.getString("name"));
			car.setBrand(rs.getString("brand"));
			car.setDescription(rs.getString("description"));
			car.setPrice(rs.getLong("price"));
			car.setProductDate(rs.getInt("productDate"));
			car.setQuantityStock(rs.getInt("quantityStock"));
			car.setImageCar(rs.getString("imageCar"));
			listCar.add(car);
		}
		return listCar;
	}
	public boolean deleteCar(int carID) throws SQLException {
		String query = "DELETE FROM car WHERE carID="+carID;
		PreparedStatement ppst = getConnection().prepareStatement(query);	
		int n = ppst.executeUpdate();
		if(n!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Car findCarById(int carID) throws SQLException {
		String query = "SELECT * FROM car WHERE carID="+carID;
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			Car car = new Car();
			car.setCarID(rs.getInt("carID"));
			car.setName(rs.getString("name"));
			car.setBrand(rs.getString("brand"));
			car.setDescription(rs.getString("description"));
			car.setPrice(rs.getLong("price"));
			car.setProductDate(rs.getInt("productDate"));
			car.setQuantityStock(rs.getInt("quantityStock"));
			car.setImageCar(rs.getString("imageCar"));
			return car;
		}
		return null;
	}
	
	public boolean updateCar(Car car, int carID) throws SQLException{
		String query = "UPDATE car SET name = ?, productDate = ?, price = ?, quantityStock = ?, description = ?, brand = ?, imageCar = ? WHERE carID = " + carID;
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, car.getName());
		ps.setInt(2, car.getProductDate());
		ps.setLong(3, car.getPrice());
		ps.setInt(4, car.getQuantityStock());
		ps.setString(5, car.getDescription());
		ps.setString(6, car.getBrand());
		ps.setString(7, car.getImageCar());
		int result = ps.executeUpdate();
		if(result != 0){
			return true;
		}
		else return false;
	}
	public boolean updateCarNoneImage(Car car, int carID) throws SQLException{
		String query = "UPDATE car SET name = ?, productDate = ?, price = ?, quantityStock = ?, description = ?, brand = ? WHERE carID = " + carID;
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, car.getName());
		ps.setInt(2, car.getProductDate());
		ps.setLong(3, car.getPrice());
		ps.setInt(4, car.getQuantityStock());
		ps.setString(5, car.getDescription());
		ps.setString(6, car.getBrand());
		int result = ps.executeUpdate();
		if(result != 0){
			return true;
		}
		else return false;
	}
}
