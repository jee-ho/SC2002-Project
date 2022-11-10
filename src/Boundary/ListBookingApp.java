package Boundary;

import Entity.Booking;
import Entity.MovieGoer;

/**
 * Runnable app for MovieGoer to list their bookings.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-10
 */
public class ListBookingApp {
	/**
	 * Main runnable function for MovieGoer to book seats.
	 * @param currentUser The current MovieGoer to check bookings for.
	 */
	public void main(MovieGoer currentUser) {
		System.out.println("Booking history for user: " + currentUser.getUsername());
		for(Booking booking: currentUser.getBookings()){
			System.out.println(booking.toString());
		}
	}
}
