package model;

public class Booking {

	private Seat seat;
	private Passenger passenger;
	
	public Booking(Seat seat, Passenger passenger){
		this.passenger = passenger;
		this.seat = seat;
	}
	
	public Passenger getPassenger(){
		return passenger;
	}
	
	public Seat getSeat(){
		return seat;
	}
}
