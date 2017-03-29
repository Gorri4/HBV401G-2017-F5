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
	
	/*public ResultSet execute(){
		
	}*/
	
	/*public ResultSet createQuery(Date d, City c){
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
		
		return null;
	}*/
	
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
	  }

}
