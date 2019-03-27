package dao;

import java.sql.*;
import java.util.ArrayList;

import connect.DBConnect;
import model.Admin;

public class AdminDAO {

	
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public ArrayList<Admin> findAllAdmin() throws SQLException{
		String query = "SELECT * FROM admin";
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Admin> listAdmin = new ArrayList<Admin>();
		while(rs.next()){
			Admin ad = new Admin();
			ad.setAccount(rs.getString("account"));
			ad.setPassword(rs.getString("password"));
			listAdmin.add(ad);
		}
		return listAdmin;
	}
}
