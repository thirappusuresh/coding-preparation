package com.mfino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://103.231.102.229:3306/lportal";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "mFino360";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet resultSet = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      stmt = conn.createStatement();
		// resultSet gets the result of the SQL query
		resultSet = stmt.executeQuery("select * from DLFolder");
		resultSet.next();
	      //STEP 4: Execute a query
/*	      System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE DATABASE STUDENTS";
	      stmt.executeUpdate(sql);
	      System.out.println("Database created successfully...");*/
	      System.out.println("Database created successfully..."+resultSet.getObject(2).toString());
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
}
