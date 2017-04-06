package control;
import java.util.ArrayList;
import model.*;

public class BookingManager {

	private ArrayList<Booking> bookings;
	
	public BookingManager() {
		this.bookings = new ArrayList<Booking>();
	}

	public void book(Seat seat, Passenger passenger){
		Booking booking = new Booking(seat,passenger);
		bookings.add(booking);	
	}
	
	public ArrayList<Booking> getBookings(){
		return bookings;
	}
		
}
