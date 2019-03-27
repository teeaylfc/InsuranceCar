package dao;

import java.sql.*;
import java.util.ArrayList;

import connect.DBConnect;
import model.Insurance;

public class InsuranceDAO {
	
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public ArrayList<Insurance> getListInsurance() throws SQLException{
		String query = "SELECT * FROM insurance";
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Insurance> list = new ArrayList<>();
		while(rs.next()) {
			Insurance insurance = new Insurance();
			insurance.setInsuranceID(rs.getInt("insuranceID"));
			insurance.setForBrand(rs.getString("forBrand"));
			insurance.setDescription(rs.getString("description"));
			insurance.setName(rs.getString("name"));
			insurance.setExp(rs.getInt("exp"));
			insurance.setPrice(rs.getInt("price"));
			insurance.setType(rs.getInt("type"));
			insurance.setQuantityStock(rs.getInt("quantityStock"));
			list.add(insurance);
		}
		return list;
	}
	public boolean addIns(Insurance i) throws SQLException{
		Connection connection = (Connection) DBConnect.getConnection();
		String sql = "INSERT INTO insurance(type, exp, price, quantityStock, forBrand, name, description) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1,i.getType());;
		ps.setInt(2,i.getExp());
		ps.setLong(3, i.getPrice());
		ps.setInt(4, i.getQuantityStock());
		ps.setString(5, i.getForBrand());
		ps.setString(6, i.getName());
		ps.setString(7, i.getDescription());
		int result = ps.executeUpdate();
		if( result != 0){
			return true;
		}else{
			return false;
		}

	}
	public boolean deleteIns(int id) throws SQLException {
		String query = "DELETE FROM insurance WHERE insuranceID="+id;
		PreparedStatement ppst = getConnection().prepareStatement(query);	
		int n = ppst.executeUpdate();
		if(n!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updateInsurance(Insurance i , int id) throws SQLException{
		String query = "UPDATE insurance SET type= ?, exp= ?, price= ?, quantityStock= ?, forBrand= ?, name= ?, description= ? WHERE insuranceID=" + id;
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setInt(1, i.getType());
		ps.setInt(2, i.getExp());
		ps.setLong(3, i.getPrice());
		ps.setInt(4, i.getQuantityStock());
		ps.setString(5, i.getForBrand());
		ps.setString(6, i.getName());
		ps.setString(7, i.getDescription());
		int result = ps.executeUpdate();
		if( result!= 0){
			return true;
		}
		else {
			return false;
		}
	}
	public Insurance findInsuranceById(int id) throws SQLException{
		String query = "SELECT * FROM insurance WHERE insuranceID=" + id;
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			Insurance i = new Insurance();
			i.setInsuranceID(rs.getInt("insuranceID"));
			i.setType(rs.getInt("type"));
			i.setExp(rs.getInt("exp"));
			i.setPrice(rs.getLong("price"));
			i.setQuantityStock(rs.getInt("type"));
			i.setForBrand(rs.getString("forBrand"));
			i.setName(rs.getString("name"));
			i.setDescription(rs.getString("description"));
			return i;
		}
		return null;
	}
}
