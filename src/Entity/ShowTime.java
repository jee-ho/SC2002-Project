package Entity;


import Controller.SeatListController;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This ShowTime class contains data about sessions of movie screenings in a cinema, and seating for the session.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class ShowTime implements Serializable {
	private Movie movie;
	private LocalDateTime showTime;
	private SeatList seatPlan;
	private Cinema cinema;
	private int id;

	/**
	 * Constructor for a ShowTime.
	 * @param movie Movie that is being screened.
	 * @param time Date and time of screening.
	 * @param cinema Cinema where screening is occurring.
	 */
	public ShowTime(Movie movie, LocalDateTime time, Cinema cinema){
		this.movie = movie;
		this.showTime = time;
		this.cinema = cinema;
		this.seatPlan = new SeatList();
	}

	/**
	 * Get the movie being screened.
	 * @return Movie being screened.
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Set the movie being screened.
	 * @param movie Movie being screened.
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * Get the date and time of screening.
	 * @return Date and time of screening.
	 */
	public LocalDateTime getShowTime() {
		return showTime;
	}

	/**
	 * Set the date and time of screening.
	 * @param showTime Date and time of screening.
	 */
	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	/**
	 * Get the list of seats for this ShowTime.
	 * @return List of seats for this ShowTime.
	 */
	public SeatList getShowSeatPlan() {
		return seatPlan;
	}

	/**
	 * Set the list of seats for this ShowTime.
	 * @param seatPlan List of seats for this ShowTime.
	 */
	public void setShowSeatPlan(SeatList seatPlan) {
		this.seatPlan = seatPlan;
	}

	/**
	 * Get the cinema where screening is occurring.
	 * @return Cinema where screening is occurring.
	 */
	public Cinema getCinema() {
		return cinema;
	}

	/**
	 * Set the cinema where screening is occurring.
	 * @param cinema Cinema where screening is occurring.
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	/**
	 * Get the ID of this ShowTime.
	 * @return ID of this ShowTime.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the ID of this ShowTime.
	 * @param id ID of this ShowTime.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Compiles all the details of a ShowTime into a printable String.
	 * @return String containing ShowTime details.
	 */
	public String toString() {
		SeatListController seatcon = new SeatListController();
		String outputString = "";
		outputString = "Showtime for movie: " + movie.getTitle() +  "\n" +
				"at time: " + showTime + "\n" +
				"at cinema: " + cinema.getNameCode() + "\n";
		return outputString;
	}
}
