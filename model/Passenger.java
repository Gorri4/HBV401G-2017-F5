package model;

public class Passenger {

	private String NAME;
	private String KENNITALA;
	
	public Passenger(String NAME, String KENNITALA) {
		this.NAME = NAME;
		this.KENNITALA = KENNITALA;
	}
	
	public String getName(){
		return NAME;
	}
	
	public String getKennitala(){
		return KENNITALA;
	}

}
