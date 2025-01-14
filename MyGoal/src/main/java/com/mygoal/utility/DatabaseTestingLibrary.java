package com.mygoal.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTestingLibrary {
	public static String driverValue = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/banking_db";
	public static String userName = "anish";
	public static String password = "anish";
	public boolean flag = false;

	public boolean verifyIntegerValue(String query, int columnName, int value) {
		try {
			Class.forName(driverValue);
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// System.out.println(rs.getInt(columnName));
				if (rs.getInt(columnName) == value) {
					flag = true;
				}
			}
			rs.close();
			stmt.close();
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}

	public boolean verifyStringValue(String query, int columnName, String value) {
		try {
			Class.forName(driverValue);
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// System.out.println(rs.getString(columnName));
				if (rs.getString(columnName) == value) {
					flag = true;
				}
			}
			rs.close();
			stmt.close();
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}
}
