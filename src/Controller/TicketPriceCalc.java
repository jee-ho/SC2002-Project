package Controller;

import Entity.Movie;
import Entity.TicketPrice;
import Entity.TicketInfo;

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

	public TicketInfo main(Movie.MovieType movieType, int age, LocalDateTime dateTime, boolean isCoupleSeat, boolean hasCard) {
		TicketPrice ticketPrice = ticketPriceController.read();
		double returnPrice = 0;
		String ticketType = "";

		if ((dateTime.getDayOfWeek() == DayOfWeek.MONDAY || dateTime.getDayOfWeek() == DayOfWeek.TUESDAY || dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY || dateTime.getDayOfWeek() == DayOfWeek.THURSDAY || dateTime.getDayOfWeek() == DayOfWeek.FRIDAY) && age >= 55 && dateTime.getHour()<18 && !holidayController.isPH(dateTime)) {
			returnPrice = ticketPrice.getSeniorCitizenWeekday();
			ticketType = "Weekday Standard Senior";
		} else if ((dateTime.getDayOfWeek() == DayOfWeek.MONDAY || dateTime.getDayOfWeek() == DayOfWeek.TUESDAY || dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY || dateTime.getDayOfWeek() == DayOfWeek.THURSDAY || dateTime.getDayOfWeek() == DayOfWeek.FRIDAY) && age <=18 && dateTime.getHour()<18 && !holidayController.isPH(dateTime)) {
				if(movieType == Movie.MovieType.TYPE_3D){
					returnPrice = ticketPrice.getStudentWeekday3D();
					ticketType = "Weekday Standard Student";
				} else {
					returnPrice = ticketPrice.getStudentWeekday();
					ticketType = "Weekday Standard Student";
				}
		} else if ((dateTime.getDayOfWeek() == DayOfWeek.MONDAY || dateTime.getDayOfWeek() == DayOfWeek.TUESDAY || dateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY)) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getMonWed3D();
				ticketType = "Weekday Standard";
			} else {
				returnPrice = ticketPrice.getMonWed();
				ticketType = "Weekday Standard";
			}

		} else if (dateTime.getDayOfWeek() == DayOfWeek.THURSDAY){
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getThu3D();
				ticketType = "Weekday Standard";
			} else {
				returnPrice = ticketPrice.getThu();
				ticketType = "Weekday Standard";
			}
		} else if (dateTime.getDayOfWeek() == DayOfWeek.FRIDAY && dateTime.getHour()<18) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getFriAft3D();
				ticketType = "Weekday Standard";
			} else {
				returnPrice = ticketPrice.getFriAft();
				ticketType = "Weekday Standard";
			}
		} else if (dateTime.getDayOfWeek() == DayOfWeek.FRIDAY && dateTime.getHour()>=18) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getFriEve3D();
				ticketType = "Weekday Standard";
			} else {
				returnPrice = ticketPrice.getFriEve();
				ticketType = "Weekday Standard";
			}
		} else if (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
			if(movieType == Movie.MovieType.TYPE_3D){
				returnPrice = ticketPrice.getWeekend3D();
				ticketType = "Weekend Standard";
			} else {
				returnPrice = ticketPrice.getWeekend();
				ticketType = "Weekend Standard";
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
		return TicketInfo.getTicketInfo(returnPrice, ticketType);
	}
}