package model;

public class Booking implements Comparable<Booking>{

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
	
	@Override
	public int compareTo(Booking y) {
		return (this.seat.getSeatNumber().compareTo(y.seat.getSeatNumber()));
    }
}
