package model;

import java.util.Date;
import java.util.Comparator;

public class DateComparator implements Comparator<Flight> {
	
	public int compare(Flight flug1, Flight flug2) {
	  Date flug1timi = flug1.getDepTime();
	  Date flug2timi = flug2.getDepTime();
      return flug1timi.compareTo(flug2timi);
  }

	
}
