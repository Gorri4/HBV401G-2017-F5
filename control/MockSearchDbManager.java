package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;


public class MockSearchDbManager implements SearchDbManagerInterface{

	public MockSearchDbManager() {
		
	}
	
	// This is a mock function that always returns an 
	// ArrayList of five fixed flight objects
	public ArrayList<Flight> createQuery(Long l, City arrCity, boolean toFrom){
		City borg1 = new City("Berlin", 0);
		City borg2 = new City("Paris", 0);
		Date dags1 = new Date(1497803417000L);
		Date dags2 = new Date(1497903450000L);
		Date dags3 = new Date(1497903460000L);
		Airplane flugvel1 = new	Airplane(1, 1, 1);
		Airline flugfelag1 = new Airline("WOW", 1, true, false);
		Airline flugfelag2 = new Airline("IcelandAir", 1, true, false);
		Airline flugfelag3 = new Airline("Emirates", 1, true, false);
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		Flight flug1 = new Flight(1, dags2, dags3, borg1, borg2, 2, 1000, flugvel1, flugfelag1); 
		Flight flug2 = new Flight(2, dags1, dags2, borg1, borg2, 2, 1200, flugvel1, flugfelag2); 
		Flight flug3 = new Flight(3, dags3, dags3, borg1, borg2, 2, 1200, flugvel1, flugfelag1); 
		Flight flug4 = new Flight(4, dags2, dags3, borg1, borg2, 2, 1000, flugvel1, flugfelag3); 
		Flight flug5 = new Flight(5, dags1, dags2, borg1, borg2, 2, 1500, flugvel1, flugfelag1); 
		flightList.add(flug1);
		flightList.add(flug2);
		flightList.add(flug3);
		flightList.add(flug4);
		flightList.add(flug5);
		return flightList;
	}
	
}
