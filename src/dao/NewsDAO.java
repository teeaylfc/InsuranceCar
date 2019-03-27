package dao;

import java.sql.*;
import connect.DBConnect;

public class NewsDAO {
	
	public Connection getConnection() {
		DBConnect db = new DBConnect();
		return db.getConnection();
		
	}

}
