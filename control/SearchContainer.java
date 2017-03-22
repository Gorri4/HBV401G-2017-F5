package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class SearchContainer {
	
	private ArrayList<Flight> flightList;
	

	public SearchContainer() {
		//return SearchContainer;
	}
	
	public ArrayList<Flight> search(int flightNum, Date date, City arrCity, City depCity, double price){
		SearchDbManager sdbm = new SearchDbManager();
		ResultSet gogn = sdbm.createQuery(flightNum, date, arrCity,depCity, price);
		List<Flight> fluglisti = new ArrayList();
		while(gogn.next()){
			Flight nyttFlug = new Flight(gogn.getInt("flightNum"), gogn.getDate("departureTime"), gogn.getDate("arrivalTime"), gogn.getString("departureCity"), gogn.getString("arrivalCity"), gogn.getString("airline"), gogn.getDouble("price"));
			fluglisti.add(nyttFlug);
		}
		
	}

}
