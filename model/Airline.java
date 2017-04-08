

package model;

//import java.util.List;

public class Airline {
	
	private String name;
	private double rating;
	private boolean includedBag;
	private boolean includedMeal;
	//private List<Flight> flights;
	//private List<Airplane> airplanes;
	
	public Airline(String name, double rating, boolean includedBag, boolean includedMeal) {
		this.name=name;
		this.rating=rating;
		this.includedBag=includedBag;
		this.includedMeal=includedMeal;
		//this.flights=flights;
		//this.airplanes=airplanes;		
	}
	
	public String getName(){
		return name;
	}
	
	public double getRating(){
		return rating;
	}
	
	public boolean isBagIncluded(){
		return includedBag;
	}
	
	public boolean isMealIncluded(){
		return includedMeal;
	}

}
