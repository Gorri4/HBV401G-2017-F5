package model;

public class City {

	private String name;
	private double timeZone;
	
	public City(String name, double timeZone) {
		this.name=name;
		this.timeZone=timeZone;
	}
	
	public String getName(){
		return name;
	}
	
	public double getTimeZone(){
		return timeZone;
	}

}
