package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.DBConnect;
import model.Brand;

public class BrandDAO {
	
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public ArrayList<Brand> getAllBrands () throws SQLException{
		String query = "SELECT * from brand";
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Brand> list = new ArrayList<>();
		while(rs.next()){
			Brand b = new Brand();
			b.setBrandID(rs.getInt("brandID"));
			b.setName(rs.getString("name"));
			list.add(b);
		}
		return list;
	}
}
