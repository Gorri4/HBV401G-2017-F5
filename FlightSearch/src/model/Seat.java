package model;

public class Seat {
	
	private String SEAT_NUMBER;
	private boolean BUISNESS_CLASS;
	private boolean booked;	
	
	public Seat(String SEAT_NUMBER, boolean BUISNESS_CLASS, boolean booked) {
		this.SEAT_NUMBER = SEAT_NUMBER;
		this.BUISNESS_CLASS = BUISNESS_CLASS;
		this.booked = booked;
	}
	
	public String getSeatNumber(){
		return SEAT_NUMBER;
	}
	
	public boolean isBuisness(){
		return SEAT_NUMBER;
	}
	
	public boolean isBooked(){
		return booked;
	}

}
