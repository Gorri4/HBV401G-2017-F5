package control;

import java.sql.*;

import model.City;

public class SearchDbManager {

	public SearchDbManager() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultSet createQuery(int flightNum, Date date, City arrCity, City depCity, double price){
		return null;
	}
	
	/*public ResultSet createQuery(Date d, City c){
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
