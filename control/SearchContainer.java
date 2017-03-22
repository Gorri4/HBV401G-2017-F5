package control;

import java.util.List;
import model.*;

public class SearchContainer {
	
	private List<Flight> flightList;
	

	public SearchContainer() {
		return SearchContainer;
	}
	
	public search(int flightNum, Date date, City arrCity, City depCity, double price){
		ResultSet gogn = createQuery(int flightNum, Date date, City arrCity, City depCity, double price);
		List<Flight> fluglisti = new List<Flight>;
		while(gogn.next()){
			Flight nyttFlug = new Flight();
			fluglisti.insert(nyttFlug);
		}
		
	}

}
