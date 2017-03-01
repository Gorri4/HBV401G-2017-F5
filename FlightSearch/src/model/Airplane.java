package model;

public class Airplane {
	
	private int numOfSeats;
	private int numOfBusinessClass;
	

	public Airplane(int numOfSeats, int numOfBusinessClass) {
		this.numOfSeats=numOfSeats;
		this.numOfBusinessClass=numOfBusinessClass;
	}
	
	public int getNumOfSeats(){
		return numOfSeats;
	}
	
	public int getNumOfBusinessClass(){
		return numOfBusinessClass;
	}
	

}
