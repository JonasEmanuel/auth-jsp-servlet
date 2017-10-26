package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;

	public void open() throws Exception{
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/auth", "postgres", "123");
	}
	
	public void close() throws Exception{
		con.close();
	}
}
