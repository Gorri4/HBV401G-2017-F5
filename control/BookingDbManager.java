package control;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDbManager {
	
	//private ArrayList<Seat,Passenger> bookings; // b�a til hlut sem er booking

	public BookingDbManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void insertToDb(Booking b){
		Connection a = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      a = DriverManager.getConnection("jdbc:sqlite:database.db");
	      PreparedStatement prepStmt = null;
	      String seat = b.getSeat().getSeatNumber();
	  	  String passenger = b.getPassenger().getName();
	  	  String kennitala = b.getPassenger().getKennitala();
	  	  int flightID = b.getFlightID();
	      String sql = "INSERT INTO Bookings (FlightID, Passenger, Kennitala, Seat) VALUES ('?', '?', '?', '?')";
	      
	      prepStmt = a.prepareStatement(sql);
	      prepStmt.setInt(1, flightID);
	      prepStmt.setString(2, passenger);
	      prepStmt.setString(3, kennitala);
	      prepStmt.setString(4, seat);
	      
	      prepStmt.execute();
	      a.close();
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    
	}
	
	public ResultSet execute(int flightID){
		Connection a = null;
		ResultSet rs = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      a = DriverManager.getConnection("jdbc:sqlite:database.db");
	      PreparedStatement prepStmt = null;
	     
	      String sql = "SELECT * FROM Bookings "
	    	  	+ "WHERE FlightID = ? ";
	      prepStmt = a.prepareStatement(sql);
	      prepStmt.setInt(1, flightID);
	      rs = prepStmt.executeQuery();

	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    return rs;
	}
	
	public ArrayList<Booking> createQuery(int flightID){
		ResultSet gogn = execute(flightID);
		ArrayList<Booking> bookingList = new ArrayList<Booking>();
		try{
			while (gogn.next()) {
				int flugNr = gogn.getInt(1);
				Passenger passenger = new Passenger(gogn.getString(3), gogn.getString(2));
				Seat seat = new Seat(gogn.getString(4), false, true);
				Booking nyBokun = new Booking(seat, passenger, flugNr);
				bookingList.add(nyBokun);
			}
		}
		catch(Exception e){
		}

		return bookingList;
	
	    
	}
	public static void main( String args[] ){
		
	}

}

