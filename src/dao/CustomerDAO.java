package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import connect.DBConnect;
import model.Customer;

public class CustomerDAO {
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
	}
	
	public ArrayList<Customer> getAllCustomer() throws SQLException{
		String query = "SELECT * FROM customer";
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Customer> list = new ArrayList<>();
		while(rs.next()){
			Customer c = new Customer();
			c.setAccount(rs.getString("account"));
			c.setPassword(rs.getString("password"));
			c.setDob(rs.getString("dob"));
			c.setAddress(rs.getString("address"));
			c.setName(rs.getString("name"));
			c.setGender(rs.getString("gender"));
			c.setCmID(rs.getInt("cmID"));
			list.add(c);
		}
		return list;
	}
	
	public Customer getCustomerById(int id) throws SQLException{
		String query = "SELECT * FROM customer WHERE cmID=" + id;
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			Customer c = new Customer();
			c.setAccount(rs.getString("account"));
			c.setPassword(rs.getString("password"));
			c.setDob(rs.getString("dob"));
			c.setAddress(rs.getString("address"));
			c.setName(rs.getString("name"));
			c.setGender(rs.getString("gender"));
			c.setCmID(rs.getInt("cmID"));
			c.setPhone(rs.getString("phone"));
			return c;
		}
		return null;
	}
	
	public boolean deleteCustomer(int id) throws SQLException{
		String query = "DELETE FROM customer WHERE cmID="+id;
		PreparedStatement ppst = getConnection().prepareStatement(query);	
		int n = ppst.executeUpdate();
		if(n!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addCustomer(Customer c) throws SQLException{
		String query = "INSERT INTO customer (name, gender, address, phone, dob, account, password) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, c.getName());
		ps.setString(2, c.getGender());
		ps.setString(3, c.getAddress());
		ps.setString(4, c.getPhone());
		ps.setString(5, c.getDob());
		ps.setString(6, c.getAccount());
		ps.setString(7, c.getPassword());
		int rs = ps.executeUpdate();
		if(rs != 0){
			return true;
		}
		return false;
	}
	
	public Customer checkLogin(String account, String password){
		String query = "SELECT * FROM customer WHERE account= ? AND password= ?";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setString(1, account);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Customer c = new Customer();
				c.setPhone(rs.getString("phone"));
				c.setAccount(rs.getString("account"));
				c.setPassword(rs.getString("password"));
				c.setDob(rs.getString("dob"));
				c.setAddress(rs.getString("address"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setCmID(rs.getInt("cmID"));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkExist(String account){
		String query = "SELECT * FROM customer WHERE account= ?";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateCustomerProfile (String name, String gender, String address, String phone, String dob, int cmID) throws SQLException{
		String query = "UPDATE customer SET name = ?, gender = ?, address = ?, phone = ?, dob = ? WHERE cmID = " + cmID;
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, gender);
		ps.setString(3, address);
		ps.setString(4, phone);
		ps.setString(5, dob);
		int result = ps.executeUpdate();
		if(result != 0){
			return true;
		}
		else return false;
	}
	
	public boolean updateCustomerPassword (String oldpass, String newpass, int cmID) throws SQLException{
		Customer c = getCustomerById(cmID);
		String currentPass = c.getPassword();
		if(oldpass.equals(currentPass)){
			String query = "UPDATE customer SET password = ? WHERE cmID = ?";
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setString(1, newpass);
			ps.setInt(2, cmID);
			int result = ps.executeUpdate();
			if(result != 0){
				return true;
			}
		}
		return false;
	}
	
}
