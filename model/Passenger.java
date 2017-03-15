package model;

public class Passenger {

	private String name;
	private String kennitala;
	
	public Passenger(String name, String kennitala) {
		this.name = name;
		this.kennitala = kennitala;
	}
	
	public String getName(){
		return name;
	}
	
	public String getKennitala(){
		return kennitala;
	}

}
