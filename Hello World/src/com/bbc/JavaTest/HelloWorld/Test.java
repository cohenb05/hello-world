package com.bbc.JavaTest.HelloWorld;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	
	public static void main(String[] args) {
		
		try {	
			System.out.println("Hello World!");
		
			//Jackson Test				
			ObjectMapper objectMapper = new ObjectMapper();
			String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
			Car car = objectMapper.readValue(carJson, Car.class);
			System.out.println("car brand = " + car.getBrand());
			System.out.println("car doors = " + car.getDoors());		
			
			ObjectMapper mapper = new ObjectMapper();
		    String jsonInput = "{\"id\" : 0, \"firstName\" : \"Robin\", \"lastName\" : \"Wilson\"}";
		    Person q = mapper.readValue(jsonInput, Person.class);
		    System.out.println("Read and parsed Person from JSON: " + q);
		    System.out.println("First name: " + q.getFirstName());
		    System.out.println("Last name: " + q.getLastName());
		    
		    DBTest();
		} 
		catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	

	
    
    public static void DBTest() {

        //String jdbcUrl = "jdbc:postgresql://localhost:5432/dvdrental";
        String jdbcUrl = "jdbc:postgresql://localhost/dvdrental";
    	//String jdbcUrl = "jdbc:postgresql://localhost/dvdrental";
        String username = "postgres";
        //String username = "postgres@PostgreSQL 10";
        String password = "hadd0ck432%";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
          // Step 1 - Load driver
          //Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

          // Step 2 - Open connection
          conn = DriverManager.getConnection(jdbcUrl, username, password);
          
          if (conn != null) {
                System.out.println("Connected to database OK");
          }


          // Step 3 - Execute statement
          stmt = conn.createStatement();
          //rs = stmt.executeQuery("SELECT version()");
          rs = stmt.executeQuery("SELECT title FROM film ORDER BY title LIMIT 1;");

          // Step 4 - Get result
          if (rs.next()) {
            System.out.println(rs.getString(1));
          }

        } catch (SQLException e) {
          e.printStackTrace();
        // } catch (ClassNotFoundException e) {
        //  e.printStackTrace();
        } finally {
          try {

            // Step 5 Close connection
            if (stmt != null) {
              stmt.close();
            }
            if (rs != null) {
              rs.close();
            }
            if (conn != null) {
              conn.close();
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
    }

	

}
