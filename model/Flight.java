package model;

import java.util.Date;

public class Flight {
	
	private int flightNum;
	private Date departureTime;
	private Date arrivalTime;
	private City departureCity;
	private City arrivalCity;
	private double flightTime;
	private double price;

	public Flight(int flightNum, Date departureTime, Date arrivalTime, City departureCity, City arrivalCity, double flightTime, double price) {
		this.flightNum=flightNum;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.departureCity=departureCity;
		this.arrivalCity=arrivalCity;
		this.flightTime=flightTime;
		this.price=price;
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
	
	public Date getLocalTime(City city, Date time){
		//skila einhvernveginn time+city.getTimeZone()
		return time;
	}

}
