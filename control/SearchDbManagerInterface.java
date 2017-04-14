package control;

import java.sql.Date;
import java.util.ArrayList;
import model.*;

public interface SearchDbManagerInterface {
	
	public ArrayList<Flight> createQuery(Long l, City arrCity, boolean toFrom);

	}
