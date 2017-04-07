package model;

//import java.util.ArrayList;
import java.util.List;

public class Airplane {
	
	private int airplaneID;
	private int numOfSeats;
	private int numOfBusinessClass;
	//private ArrayList<Seat> seats;
	

	public Airplane(int numOfSeats, int numOfBusinessClass, int airplaneID) {
		this.airplaneID=airplaneID;
		this.numOfSeats=numOfSeats;
		this.numOfBusinessClass=numOfBusinessClass;
		//this.seats = seats;
	}
	
	public int getNumOfSeats(){
		return numOfSeats;
	}
	
	public int getNumOfBusinessClass(){
		return numOfBusinessClass;
	}
	
	public int getAirplaneID(){
		return airplaneID;
	}
}
