package control;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDbManager {
	
	//private ArrayList<Seat,Passenger> bookings; // b�a til hlut sem er booking

	public BookingDbManager() {
		// TODO Auto-generated constructor stub
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

