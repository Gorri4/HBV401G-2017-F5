package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.*;

public class SearchContainer {
	
	private ArrayList<Flight> flightList;
	

	public SearchContainer() {
		//return SearchContainer;
	}
	
	public ArrayList<Flight> search(int flightNum, Date date, City arrCity, City depCity, double price){
		SearchDbManager sdbm = new SearchDbManager();
		ResultSet gogn = sdbm.createQuery(flightNum, date, arrCity,depCity, price);
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

}
