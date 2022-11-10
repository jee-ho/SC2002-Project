package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This Booking class contains information about a MovieGoer's booking.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-10
 */
public class Booking implements Serializable {
	private String TID;
	private String cinemaNameCode;
	private LocalDateTime time;
	private String movieName;

	/**
	 * Constructor for a Booking.
	 * @param TID Printable transaction ID string of booking.
	 * @param cinemaNameCode Codename of cinema for ShowTime being booked.
	 * @param time Time of ShowTime being booked.
	 * @param movieName Movie title of ShowTime being booked.
	 */
	public Booking(String TID, String cinemaNameCode, LocalDateTime time, String movieName) {
		this.TID = TID;
		this.cinemaNameCode = cinemaNameCode;
		this.time = time;
		this.movieName = movieName;
	}

	/**
	 * Get the printable transaction ID string of booking.
	 * @return Printable transaction ID string of booking.
	 */
	public String getTID() {
		return TID;
	}
	/**
	 * Set the printable transaction ID string of booking.
	 * @param TID Printable transaction ID string of booking.
	 */
	public void setTID(String TID) {
		this.TID = TID;
	}
	/**
	 * Get the codename of cinema for ShowTime being booked.
	 * @return Codename of cinema for ShowTime being booked.
	 */
	public String getCinemaNameCode() {
		return cinemaNameCode;
	}
	/**
	 * Set the codename of cinema for ShowTime being booked.
	 * @param cinemaNameCode Codename of cinema for ShowTime being booked.
	 */
	public void setCinemaNameCode(String cinemaNameCode) {
		this.cinemaNameCode = cinemaNameCode;
	}
	/**
	 * Get the time of ShowTime being booked.
	 * @return time of ShowTime being booked.
	 */
	public LocalDateTime getTime() {
		return time;
	}
	/**
	 * Set the time of ShowTime being booked.
	 * @param time Time of ShowTime being booked.
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	/**
	 * Get the movie title of ShowTime being booked.
	 * @return Movie title of ShowTime being booked.
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * Set the movie title of ShowTime being booked.
	 * @param movieName Movie title of ShowTime being booked.
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * Prints a string of this Booking's details.
	 * @return String of this Booking's details.
	 */
	public String toString(){
		String outputString = "";
		outputString += "Booking " + TID + ": \n";
		outputString += "Cinema: " + cinemaNameCode + "\n";
		outputString += "Date/time: " + time + "\n";
		outputString += "Movie: " + movieName + "\n";
		return outputString;
	}
}
