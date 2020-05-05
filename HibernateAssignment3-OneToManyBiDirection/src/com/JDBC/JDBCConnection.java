package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kayhan_academy?allowPublicKeyRetrieval=true&useSSL=false", "hbstudent", "hbstudent");
			System.out.println("Connection Successfull..............");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
