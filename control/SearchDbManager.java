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
