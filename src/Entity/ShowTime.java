package Entity;


import Controller.SeatListController;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ShowTime implements Serializable {
	private Movie movie;
	private LocalDateTime showTime;
	private SeatList seatPlan;
	private Cinema cinema;
	private int id;

	public ShowTime(Movie movie, LocalDateTime time, Cinema cinema){
		this.movie = movie;
		this.showTime = time;
		this.cinema = cinema;
		this.seatPlan = new SeatList();
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public SeatList getShowSeatPlan() {
		return seatPlan;
	}

	public void setShowSeatPlan(SeatList seatPlan) {
		this.seatPlan = seatPlan;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isWeekendPrice(){
		return showTime.getDayOfWeek() == DayOfWeek.SATURDAY || showTime.getDayOfWeek() == DayOfWeek.SUNDAY || showTime.getDayOfWeek() == DayOfWeek.FRIDAY && showTime.getHour() > 18;
	}

	public LocalTime getStartTime() {
		return getShowTime().toLocalTime();
	}

	public LocalTime getEndTime(){
		return getStartTime().plusMinutes(60* getMovie().getDuration());
	}

	public String toString() {
		SeatListController seatcon = new SeatListController();
		String outputString = "";
		outputString = "Showtime for movie: " + movie.getTitle() +  "\n" +
				"at time: " + showTime + "\n" +
				"at cinema: " + cinema.getNameCode() + "\n";
		return outputString;
	}
}
