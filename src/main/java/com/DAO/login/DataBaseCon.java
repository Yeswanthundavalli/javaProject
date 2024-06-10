package com.DAO.login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DataBaseCon {

	String sql = "select * from LoginUserData where username=? and password=?";
	
	String url = "jdbc:mysql://localhost:3306/Project";
	
	String Dausername = "root";
	
	String Dapassword = "prasad143tara+asha";
	
	public boolean check (String uname, String password) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,Dausername,Dapassword);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

		return false;
		
	}
}
