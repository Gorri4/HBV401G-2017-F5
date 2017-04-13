package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import model.*;

public class SearchContainer {
	
	private ArrayList<Flight> flightList;
	private SearchDbManagerInterface SDBMinterface;
	

	public SearchContainer(SearchDbManagerInterface SDBMinterface) {
		this.SDBMinterface = SDBMinterface;
	}
	
	public ArrayList<Flight> filter(String[] flugfelog, ArrayList<Flight> flug){
		ArrayList<Flight> filteredFlightList = new ArrayList<Flight>();
		if (flugfelog.length != 0){
			for(String flugfelag : flugfelog){
				for(Flight f : flug){
					if (f.getAirline().getName().compareTo(flugfelag)==0){
						filteredFlightList.add(f);
					}
				}
			}
			return filteredFlightList;
		}
		else{
			return this.flightList;
		}
	}
	
	public ArrayList<Flight> sort(ArrayList<Flight> fluglisti, String s, Boolean r){
		if (s == "date"){
			Collections.sort(fluglisti, new DateComparator());
		}
		else {
			Collections.sort(fluglisti);
		}
		if (r == false){
			return fluglisti;
		}
		else{
			Collections.reverse(fluglisti);
			return fluglisti;
		}	
	}
	
	public ArrayList<Flight> search(int flightNum, Long l, City arrCity, City depCity, double price){
		ArrayList<Flight> newFlightList = SDBMinterface.createQuery(l, arrCity);
		this.flightList = newFlightList;
		return newFlightList;
	}
	
	public ArrayList<Flight> getList(){
		return flightList;
	}

}
