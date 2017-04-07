package control;

import java.sql.*;
import java.util.ArrayList;

import model.*;

public class SearchDbManager implements SearchDbManagerInterface {

	public SearchDbManager() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Flight> createQuery(int flightNum, Date date, City arrCity, City depCity, double price){
		return null;
	}
	
	public ResultSet execute(Date d, City c){
		Connection a = null;
		ResultSet rs = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      a = DriverManager.getConnection("jdbc:sqlite:database.db");
	      
	      Statement st = a.createStatement();
	      String s = "SELECT * FROM Flights;";
	      rs = st.executeQuery(s);
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    return rs;
	}
	
	public ArrayList<Flight> createQuery(Date d, City c){
		ResultSet gogn = execute(d, c);
		ArrayList<Flight> flightList = new ArrayList<Flight>();
	 	try{
				while(gogn.next()){
					City dCity = new City(gogn.getString("departureCity"), 0);
					City aCity = new City(gogn.getString("arrivalCity"), 0);
					Airplane plane = new Airplane(1, 1, null, gogn.getInt("airplaneID"));
					Airline al = new Airline(gogn.getString("airline"), 0, true, true, null, null);
					Flight nyttFlug = new Flight(gogn.getInt("flightNum"), 
												gogn.getDate("departureTime"), 
												gogn.getDate("arrivalTime"), 
												dCity, 
												aCity,
												1,
												gogn.getDouble("price"),
												plane,
												al);
					flightList.add(nyttFlug);
				}
			}
			catch(Exception e){
			
		}
		return flightList;
	}
	
	public static void main( String args[] )
	  {
	    /*Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");*/
	  
		
		
		Connection a = null;
		ResultSet rs = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      a = DriverManager.getConnection("jdbc:sqlite:database.db");
	      
	      Statement st = a.createStatement();
	      String s = "SELECT * FROM Flights;";
	      rs = st.executeQuery(s);
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    
	    
	    
	    //prenta resultset
	    try{
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columnsNumber = rsmd.getColumnCount();
		    while (rs.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = rs.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
	    }catch(Exception e){
	    	
	    }
	    
	  }
}

