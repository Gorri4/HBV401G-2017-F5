package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

import model.*;

public class SearchDbManager implements SearchDbManagerInterface {

	public SearchDbManager() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection getConnection(){
		Connection a = null;
		try{
			Class.forName("org.sqlite.JDBC");
			a = DriverManager.getConnection("jdbc:sqlite:database.db");
			
			}
		catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
		return a;
	}
	
	private CachedRowSet execute(Long l, City c){
		Connection a = null;
		ResultSet rs = null;
		CachedRowSet rowset = null;
	    try {
	      a = getConnection();
	      PreparedStatement prepStmt = null;
	      if (l == null){
	    	  String borg = c.getName();
	    	  String sql = "SELECT * FROM Flights "
	    	  		+ "WHERE arrivalCity = ? ";
	    	  prepStmt = a.prepareStatement(sql);
	    	  prepStmt.setString(1, borg);
	      }
	      else if (c.getName() == null) {
	    	  String sql = "SELECT * FROM Flights "
	    	  		+ "WHERE departureTime BETWEEN ? and ? ";
	    	  prepStmt = a.prepareStatement(sql);
	    	  prepStmt.setLong(1, l);
	    	  prepStmt.setLong(2, l + 86400000);
	      }	
	      else{
	    	  String borg = c.getName();
	    	  String sql = "SELECT * FROM Flights "
	    	  		+ "WHERE arrivalCity = ? "
	    	  		+ "AND departureTime BETWEEN ? and ? ";
	    	  prepStmt = a.prepareStatement(sql);
	    	  prepStmt.setString(1, borg);
	    	  prepStmt.setLong(2, l);
	    	  prepStmt.setLong(3, l + 86400000);
	      }
	      rs = prepStmt.executeQuery();	  
	      rowset = new CachedRowSetImpl();
	      rowset.populate(rs);
	      a.close();
	    } 
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
		
	    return rowset;
	    
	}
	
	private CachedRowSet executeAirplane(int airplaneID){
		Connection a = null;
		ResultSet rs = null;
		CachedRowSet rowset = null;
	    try {
	      a = getConnection();
	      PreparedStatement prepStmt = null;
	      String sql = "SELECT Seats, BusinessSeats FROM Airplanes "
	    	  		+ "WHERE AirplaneID = ? ";
	      prepStmt = a.prepareStatement(sql);
	      prepStmt.setInt(1, airplaneID);
	      rs = prepStmt.executeQuery();
	      rowset = new CachedRowSetImpl();
	      rowset.populate(rs);
	      a.close();
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }

	    return rowset;
	}
	
	private CachedRowSet executeAirline(String airline){
		Connection a = null;
		ResultSet rs = null;
		CachedRowSet rowset = null;
	    try {
	      a = getConnection();
	      PreparedStatement prepStmt = null;
	      String sql = "SELECT rating, includedBag, includedMeal FROM Airlines "
	    	  		+ "WHERE name = ? ";
	      prepStmt = a.prepareStatement(sql);
	      prepStmt.setString(1, airline);
	      rs = prepStmt.executeQuery();
	      rowset = new CachedRowSetImpl();
	      rowset.populate(rs);
	      a.close();
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }

	    return rowset;
	}
	
	public ArrayList<Flight> createQuery(Long l, City c){
		CachedRowSet gogn = execute(l, c);
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		try{
			while (gogn.next()) {
				int flugNr = gogn.getInt(1);
				City dCity = new City(gogn.getString(4), 0);
				City aCity = new City(gogn.getString(5), 0);
				
				CachedRowSet flugvel = executeAirplane(gogn.getInt(8));
				flugvel.next();
				Airplane plane = new Airplane(flugvel.getInt(1), flugvel.getInt(2), gogn.getInt(8));
				
				BookingManager manager = new BookingManager();
				if(flugvel.getInt(1) == manager.getBookedSeats(flugNr).size()){ //ef uppbókað
					continue;
				}
				
				CachedRowSet flugfelag = executeAirline(gogn.getString(6));
				flugfelag.next();
				Boolean Bag = flugfelag.getInt(2)==1;
				Boolean Meal = flugfelag.getInt(3)==1;
				System.out.println("lol");
				Airline al = new Airline(gogn.getString(6), flugfelag.getDouble(1), Bag, Meal);
				
				Double timi = 9.4;
				Date arrTime = new Date(gogn.getLong(2));
				Date depTime = new Date(gogn.getLong(3));
				System.out.println(arrTime.toString());
				Double verd = gogn.getDouble(7);
				Flight nyttFlug = new Flight(flugNr, arrTime, depTime, dCity, aCity, timi, verd, plane, al);
				flightList.add(nyttFlug);
			}
		}
		catch(Exception e){
		}

		return flightList;
	
	    
	}
	
	public static void main( String args[] ){
	  
	  }
}

