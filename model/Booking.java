package model;

public class Booking {

	private Seat seat;
	private Passenger passenger;
	private int flightID;
	
	public Booking(Seat seat, Passenger passenger, int flightID){
		this.passenger = passenger;
		this.seat = seat;
	}
	
	public Passenger getPassenger(){
		return passenger;
	}
	
	public Seat getSeat(){
		return seat;
	}
	
	public int getFlightID(){
		return flightID;
	}
}
