package Controller;

import Entity.Movie;
import Entity.TicketPrice;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Special controller for calculating ticket prices.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-09
 */
public class TicketPriceCalc {
	TicketPriceController ticketPriceController = new TicketPriceController();
	HolidayController holidayController = new HolidayController();

	/**
	 * Calculate ticket price based on MovieGoer and Movie details.
	 * @param movieType Type of Movie.
	 * @param age Age of MovieGoer.
	 * @param dateTime Date and time of screening.
	 * @param isCoupleSeat True if a couple seat is being bought.
	 * @param hasCard True if MovieGoer is booking with a credit/loyalty card.
	 * @return Price of ticket.
	 */
	public double main(Movie.MovieType movieType, int age, LocalDateTime dateTime, boolean isCoupleSeat, boolean hasCard) {
		TicketPrice ticketPrice = ticketPriceController.read();
		double returnPrice = 0;

		if ((dateTime.getDayOfWeek() == DayOfWeek.MONDAY || dateTime.getDayOfWeek() == DayOfWeek.TUESDAY || dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY || dateTime.getDayOfWeek() == DayOfWeek.THURSDAY || dateTime.getDayOfWeek() == DayOfWeek.FRIDAY) && age >= 55 && dateTime.getHour()<18 && !holidayController.isPH(dateTime)) {
			returnPrice = ticketPrice.getSeniorCitizenWeekday();
		} else if ((dateTime.getDayOfWeek() == DayOfWeek.MONDAY || dateTime.getDayOfWeek() == DayOfWeek.TUESDAY || dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY || dateTime.getDayOfWeek() == DayOfWeek.THURSDAY || dateTime.getDayOfWeek() == DayOfWeek.FRIDAY) && age <=18 && dateTime.getHour()<18 && !holidayController.isPH(dateTime)) {
				if(movieType == Movie.MovieType.TYPE_3D){
					returnPrice = ticketPrice.getStudentWeekday3D();
				} else {
					returnPrice = ticketPrice.getStudentWeekday();
				}
		} else if ((dateTime.getDayOfWeek() == DayOfWeek.MONDAY || dateTime.getDayOfWeek() == DayOfWeek.TUESDAY || dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY)) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getMonWed3D();
			} else {
				returnPrice = ticketPrice.getMonWed();
			}

		} else if (dateTime.getDayOfWeek() == DayOfWeek.THURSDAY){
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getThu3D();
			} else {
				returnPrice = ticketPrice.getThu();
			}
		} else if (dateTime.getDayOfWeek() == DayOfWeek.FRIDAY && dateTime.getHour()<18) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getFriAft3D();
			} else {
				returnPrice = ticketPrice.getFriAft();
			}
		} else if (dateTime.getDayOfWeek() == DayOfWeek.FRIDAY && dateTime.getHour()>=18) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getFriEve3D();
			} else {
				returnPrice = ticketPrice.getFriEve();
			}
		} else if (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getWeekend3D();
			} else {
				returnPrice = ticketPrice.getWeekend();
			}
		}

		if (hasCard) {
			returnPrice = ticketPrice.getCard();
		}
		if (movieType == Movie.MovieType.TYPE_BLOCKBUSTER) {
			returnPrice += 1;
		}

		if (isCoupleSeat) {
			returnPrice *= 2;
		}
		return returnPrice;
	}
}