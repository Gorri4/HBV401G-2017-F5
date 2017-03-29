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
		else{
			return flightList;
		}
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
		return flightList;
		
	}

}
