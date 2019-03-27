package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import model.OwnCar;

public class OwnCarDAO {
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public boolean addOwnCar(OwnCar o){
		String query = "INSERT INTO owncar (cmID, carNumber, numberOfSeat,haveInsurance, brand) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setInt(1, o.getCmID());
			ps.setString(2, o.getCarNumber());
			ps.setInt(3, o.getNumberOfSeat());
			ps.setInt(4, o.getHaveInsurance());
			ps.setString(5, o.getBrand());
			int rs = ps.executeUpdate();
			if( rs != 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<OwnCar> getListOwnCarByCmID(int cmID) throws SQLException{
		String query = "SELECT * FROM owncar WHERE cmID= ?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setInt(1, cmID);
		ResultSet rs = ps.executeQuery();
		ArrayList<OwnCar> list = new ArrayList<OwnCar>();
		while(rs.next()){
			OwnCar o = new OwnCar();
			o.setBrand(rs.getString("brand"));
			o.setCarNumber(rs.getString("carNumber"));
			o.setHaveInsurance(rs.getInt("haveInsurance"));
			o.setNumberOfSeat(rs.getInt("numberOfSeat"));
			o.setCmID(rs.getInt("cmID"));
			o.setOwncarID(rs.getInt("owncarID"));
			list.add(o);
		}
		return list;
	}
	
	public OwnCar getOwnCarByOwnCarID(int owncarID) throws SQLException{
		String query = "SELECT * FROM owncar WHERE owncarID= ?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setInt(1, owncarID);
		ResultSet rs = ps.executeQuery();
		OwnCar o = new OwnCar();
		if(rs.next()){
			o.setBrand(rs.getString("brand"));
			o.setCarNumber(rs.getString("carNumber"));
			o.setHaveInsurance(rs.getInt("haveInsurance"));
			o.setNumberOfSeat(rs.getInt("numberOfSeat"));
			o.setCmID(rs.getInt("cmID"));
			o.setOwncarID(rs.getInt("owncarID"));
			return o;
		}
		return null;
	}
	
	public boolean updateOwnCar(String carNumber, int numberOfSeat, int haveInsurance, String brand, int owncarID) throws SQLException{
		String query = "UPDATE owncar SET carNumber=?, numberOfSeat=?, haveInsurance=?, brand=? WHERE owncarID= ?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, carNumber);
		ps.setInt(2, numberOfSeat);
		ps.setInt(3, haveInsurance);
		ps.setString(4, brand);
		ps.setInt(5, owncarID);
		int rs = ps.executeUpdate();
		if(rs != 0){
			return true;
		}
		return false;
	}
	
	public boolean delOwnCar(int owncarID) throws SQLException{
		String query = "DELETE FROM owncar WHERE owncarID=?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setInt(1, owncarID);
		int rs = ps.executeUpdate();
		if(rs!= 0){
			return true;
		}
		return false;
	}
	
	public ArrayList<OwnCar> getListOwnCarByBrand(String brand) throws SQLException{
		String query = "SELECT * FROM owncar WHERE brand= ? AND haveInsurance=?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, brand);
		ps.setInt(2, 0);
		ResultSet rs = ps.executeQuery();
		ArrayList<OwnCar> list = new ArrayList<OwnCar>();
		while(rs.next()){
			OwnCar o = new OwnCar();
			o.setBrand(rs.getString("brand"));
			o.setCarNumber(rs.getString("carNumber"));
			o.setHaveInsurance(rs.getInt("haveInsurance"));
			o.setNumberOfSeat(rs.getInt("numberOfSeat"));
			o.setCmID(rs.getInt("cmID"));
			o.setOwncarID(rs.getInt("owncarID"));
			list.add(o);
		}
		return list;
	}
	
}
