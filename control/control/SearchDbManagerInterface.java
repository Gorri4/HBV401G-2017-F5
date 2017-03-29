package control;

import java.sql.Date;
import java.util.ArrayList;

public interface SearchDbManagerInterface {
	
	public abstract ArrayList<Flight> createQuery(int flightNum, Date date, City arrCity, City depCity, double price);

}
