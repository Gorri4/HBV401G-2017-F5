package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import model.*;

public class SearchContainer {
	
	private ArrayList<Flight> flightList;
	

	public SearchContainer() {
		//return SearchContainer;
	}
	
	
	public ArrayList<Flight> filter(String[] flugfelog){
		ArrayList<Flight> filteredFlightList = new ArrayList<Flight>();
		if (flugfelog.length != 0){
			for(String flugfelag : flugfelog){
				for(Flight flug : flightList){
					if (flug.getAirline().getName() == flugfelag){
						filteredFlightList.add(flug);
					}
				}
			}
			return filteredFlightList;
		}
		return flightList;
	}
	
	
	public ArrayList<Flight> sort(String s){
		if (s == "date"){
			Collections.sort(this.flightList, new DateComparator());
			return flightList;
		}
		else {
			Collections.sort(this.flightList);
			return flightList;
		}
		
	}
	
	public ArrayList<Flight> search(int flightNum, Date date, City arrCity, City depCity, double price){
		SearchDbManager sdbm = new SearchDbManager();
		ArrayList<Flight> flightlist = sdbm.createQuery(flightNum, date, arrCity,depCity, price);
		/*
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
		*/
		return flightList;
		
	}

}
