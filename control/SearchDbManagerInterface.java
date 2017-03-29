package control;

import java.sql.Date;
import java.util.ArrayList;
import model.*;

public interface SearchDbManagerInterface {
	
	public ArrayList<Flight> createQuery(int flightNum, Date date, City arrCity, City depCity, double price);

	}
