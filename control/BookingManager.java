package control;
import java.util.ArrayList;
import java.util.Collections;

import model.*;

public class BookingManager {

	private ArrayList<Booking> bookings;
	
	public BookingManager() {
		this.bookings = new ArrayList<Booking>();
	}

	public void book(Seat seat, Passenger passenger, int flightID){
		Booking booking = new Booking(seat,passenger,flightID);
		//bookings.add(booking);
		BookingDbManager manager = new BookingDbManager();
		manager.insertToDb(booking);
	}
	
	public ArrayList<Booking> getBookings(int flightID){
		BookingDbManager manager = new BookingDbManager();
		this.bookings = manager.createQuery(flightID);
		Collections.sort(bookings);
		return bookings;
	}
		
}
