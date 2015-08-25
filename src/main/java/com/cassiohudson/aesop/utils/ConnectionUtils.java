package com.cassiohudson.aesop.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {

	public static final String HOST = "jdbc:mysql://192.185.21.67:3306/cassio_aesop";
	private static final String USERNAME = "cassio_aesop";
	private static final String PASSWORD = "qODS)0Umg=$~";
	
	public static Connection newConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		try {
			return DriverManager.getConnection(HOST, USERNAME ,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void executeSql(String sql){
		Connection con;
		con =  ConnectionUtils.newConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResults(String sql){
		ResultSet rs; Connection con;
		con =  ConnectionUtils.newConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(ResultSet conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
    }
	
	public static void close(BufferedReader conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }
	
	
	public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
    }
}
