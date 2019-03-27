package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import connect.DBConnect;
import model.RegisterInsurance;

public class RegisterInsuranceDAO {
	
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public boolean addRegisterInsurance (String carNumber, int insuranceID, String registeredDate, int cmID){
		String query = "INSERT INTO registerinsurance (carNumber, insuranceID, registeredDate, cmID, status) VALUES (?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ps.setString(1, carNumber);
			ps.setInt(2, insuranceID);
			ps.setString(3, registeredDate);
			ps.setInt(4, cmID);
			ps.setInt(5, 1);
			int rs = ps.executeUpdate();
			if(rs != 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean acceptRegisterInsurance (int riID){
		String query = "UPDATE registerinsurance SET status= ?  WHERE riID= ?";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ps.setInt(1, 2);
			ps.setInt(2, riID);
			ps.executeUpdate();
				System.out.println("THAY DOI DUOC");
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("KHONG THAY DOI DUOC");
		return false;
	}
	
	public boolean rejectRegisterInsurance (int riID){
		String query = "UPDATE registerinsurance SET status= ?  WHERE riID= ?";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2, riID);
			System.out.println(ps.toString());
			ps.executeUpdate();
			System.out.println("Huy DUOC");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("KHONG Huy DUOC");
		return false;
	}
	
	public boolean deleteRegisteredInsurance (int riID){
		String query = "DELETE FROM registerinsurance WHERE riID= ?";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ps.setInt(1, riID);
			int rs = ps.executeUpdate();
			if(rs != 0 ) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<RegisterInsurance> getAllPendingInsurances (){
		String query = "SELECT * FROM registerinsurance WHERE status=1";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ArrayList<RegisterInsurance> list = new ArrayList<>();
			while(rs.next()){
				RegisterInsurance ri = new RegisterInsurance();
				ri.setRiID(rs.getInt("riID"));
				ri.setCarNumber(rs.getString("carNumber"));
				ri.setCmID(rs.getInt("cmID"));
				ri.setInsuranceID(rs.getInt("insuranceID"));
				ri.setStatus(rs.getInt("status"));
				ri.setRegisterDate(rs.getString("registeredDate"));
				list.add(ri);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<RegisterInsurance> getAllRegisteredInsurances (){
		String query = "SELECT * FROM registerinsurance WHERE status=2";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ArrayList<RegisterInsurance> list = new ArrayList<>();
			while(rs.next()){
				RegisterInsurance ri = new RegisterInsurance();
				ri.setRiID(rs.getInt("riID"));
				ri.setCarNumber(rs.getString("carNumber"));
				ri.setCmID(rs.getInt("cmID"));
				ri.setInsuranceID(rs.getInt("insuranceID"));
				ri.setStatus(rs.getInt("status"));
				ri.setRegisterDate(rs.getString("registeredDate"));
				list.add(ri);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<RegisterInsurance> getAllRegisteredInsurancesByCmID (int cmID){
		String query = "SELECT * FROM registerinsurance WHERE cmID=?";
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
			ps.setInt(1, cmID);
			ResultSet rs = ps.executeQuery();
			ArrayList<RegisterInsurance> list = new ArrayList<>();
			while(rs.next()){
		
				RegisterInsurance ri = new RegisterInsurance();
				ri.setCarNumber(rs.getString("carNumber"));
				ri.setCmID(rs.getInt("cmID"));
				ri.setInsuranceID(rs.getInt("insuranceID"));
				ri.setStatus(rs.getInt("status"));
				ri.setRegisterDate(rs.getString("registeredDate"));
				list.add(ri);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
