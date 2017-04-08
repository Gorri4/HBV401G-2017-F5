package model;

import java.sql.Date;

public class Flight implements Comparable<Flight>{
	
	private int flightNum;
	private Date departureTime;
	private Date arrivalTime;
	private City departureCity;
	private City arrivalCity;
	private double flightTime;
	private double price;
	private Airplane airplane;
	private Airline airline;

	public Flight(int flightNum, Date departureTime, Date arrivalTime, City departureCity, City arrivalCity, double flightTime, double price, Airplane airplane, Airline airline) {
		this.flightNum=flightNum;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.departureCity=departureCity;
		this.arrivalCity=arrivalCity;
		this.flightTime=flightTime;
		this.price=price;
		this.airplane = airplane;
		this.airline = airline;
	}
	
	public int getFlightNum(){
		return flightNum;
	}
	public Date getDepTime(){
		return departureTime;
	}
	
	public Date getArrTime(){
		return arrivalTime;
	}
	
	public City getDepCity(){
		return departureCity;
	}
	
	public City getArrCity(){
		return arrivalCity;
	}
	
	public double getFlightTime(){
		return flightTime;
	}
	
	public double getPrice(){
		return price;
	}
	
	public Airline getAirline(){
		return airline;
	}
	
	public Airplane getAirplane(){
		return airplane;
	}
	
	public Date getLocalTime(City city, Date time){
		//skila einhvernveginn time+city.getTimeZone()
		return time;
	}

	// x.compareTo(y) returns 1 if x is more expensive than y, 
	// -1 if x is cheaper than y but 0 if they are equally expensive
	@Override
	public int compareTo(Flight y) {
		return (int)(this.price - y.price);
    }

	public String toString() { 
	    return "FlightNum: " + this.flightNum + ", Departure: " + this.getDepTime().toString() + ", From: " + this.getDepCity().getName() +", To: '" + this.getArrCity().getName() + ", Airline: " + this.getAirline().getName() ;
	} 
	
}
