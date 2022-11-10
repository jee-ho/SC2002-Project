package Controller;

import Entity.Booking;
import Entity.MovieGoer;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Controller for interfacing with Booking objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-10
 */
public class BookingController {
	/**
	 * Adds a new Booking for a given user and ShowTime details being booked.
	 * @param user Username of MovieGoer doing the booking.
	 * @param TID Printable transaction ID string of booking.
	 * @param cinemaNameCode Codename of cinema for ShowTime being booked.
	 * @param time Time of ShowTime being booked.
	 * @param movieName Movie title of ShowTime being booked.
	 * @return The Booking object being added.
	 */
	public Booking addBooking(MovieGoer user, String TID, String cinemaNameCode, LocalDateTime time, String movieName){
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		Booking bookingToBeAdded = new Booking(TID, cinemaNameCode, time, movieName);
		bookings = user.getBookings();
		bookings.add(bookingToBeAdded);
		user.setBookings(bookings);
		UserController userController = new UserController();
		userController.updateMovieGoer(user.getUsername(), user.getFullName(), user.getMobileNo(), user.getEmail(), user.getAge(), bookings);
		return bookingToBeAdded;
	}
}
