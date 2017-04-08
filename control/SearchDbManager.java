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
	      String borg = c.getName();
	      String s = String.format("SELECT * FROM Flights WHERE arrivalCity = '%s'",borg);
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
			while (gogn.next()) {
				City dCity = new City(gogn.getString(4), 0);
				City aCity = new City(gogn.getString(5), 0);
				Airplane plane = new Airplane(1, 1, gogn.getInt(8));
				Airline al = new Airline(gogn.getString(6), 0, true, true);
				Double timi = 9.4;
				int flugNr = gogn.getInt(1);
				Date arrTime = new Date(gogn.getLong(2));
				Date depTime = new Date(gogn.getLong(3));
				Double verd = gogn.getDouble(7);
				Flight nyttFlug = new Flight(flugNr, arrTime, depTime, dCity, aCity, timi, verd, plane, al);
				flightList.add(nyttFlug);
			}
		}
		catch(Exception e){
		}

		return flightList;
	
	    
	}
	
	public static void main( String args[] )
	  {
	    Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:database.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	  
		
		
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

