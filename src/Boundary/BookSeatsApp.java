package Boundary;

import Controller.*;
import Entity.Movie;
import Entity.MovieGoer;
import ExceptionPackage.SeatDoesNotExistException;
import ExceptionPackage.SeatOccupiedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookSeatsApp {
	MovieController movieController = new MovieController();
	ShowTimeController showTimeController = new ShowTimeController();
	UserController userController = new UserController();
	public void main(MovieGoer currentUser) {
		int choice = 0;
		while(true){
			movieController.getMovieCatalog();
			System.out.println("Enter any movie's number to see more showtimes, enter 0 to exit.");
			choice = ScannerController.getInputInt();
			choice--;
			if(choice == -1) {
				return;
			}
			if(movieController.getMovieByNo(choice).getStatus() == Movie.ShowStatus.PREVIEW){
				System.out.println("This movie is for preview only, no booking allowed.");
				return;
			}
			while(true){
				showTimeController.getAllShowTimesForMovie(movieController.getMovieByNo(choice).getTitle());
				int showChoice = 0;
				System.out.println("Enter any showtime's number to see the seat availability, enter 0 to exit.");
				showChoice = ScannerController.getInputInt();
				showChoice--;
				if(showChoice == -1){
					break;
				}
				showTimeController.getSeatingForShowtime(showChoice);
					while(true){
						int bookChoice = 0;
						System.out.println("Do you want to book a seat for this showtime? Enter 1 if yes, 0 if no.");
						bookChoice = ScannerController.getInputInt();
						if(bookChoice == 1){
							char row = ' ';
							int col = 0;
							System.out.println("Please enter a row letter");
							row = ScannerController.getInputString().charAt(0);
							System.out.println("Please enter a column number");
							col = ScannerController.getInputInt();
							try {
								showTimeController.updateSeatStatus(showTimeController.read().get(showChoice), showTimeController.read().get(showChoice).getShowSeatPlan().bookSeat(row, col));
							} catch (SeatDoesNotExistException e) {
								System.out.println("Seat does not exist, please try again");
								break;
							} catch (SeatOccupiedException e) {
								System.out.println("Seat is already occupied, please try again");
								break;
							}




							System.out.println("Please enter your details to confirm your booking");
							System.out.println("Please enter your name");
							String fullName = ScannerController.getInputString();
							System.out.println("Please enter your mobile number");
							int mobileNo = ScannerController.getInputInt();
							System.out.println("Please enter your email address");
							String email = ScannerController.getInputString();
							System.out.println("Please enter your age");
							int age = ScannerController.getInputInt();
							userController.updateMovieGoer(currentUser.getUsername(), fullName, mobileNo, email, age);

							boolean isCoupleSeat = showTimeController.read().get(showChoice).getShowSeatPlan().isCoupleSeat(row, col);
							boolean hasCard = false;
							System.out.println("Do you have a preferred credit/loyalty card? Enter 1 for yes, 0 for no");
							if(ScannerController.getInputInt() == 1){
								hasCard = true;
								System.out.println("Preferred credit/loyalty card confirmed");
							}
							TicketPriceCalc ticketPriceCalc = new TicketPriceCalc();
							double ticketPrice = ticketPriceCalc.main(movieController.getMovieByNo(choice).getType(), age, showTimeController.read().get(showChoice).getShowTime(), isCoupleSeat, hasCard);
							movieController.addMovieEarning(movieController.getMovieByNo(choice).getTitle(), ticketPrice);

							//TODO add current booking to user history, include TID

							System.out.println("Seat booked at " + row + col);
							System.out.println("Price: " + ticketPrice);
							DateTimeFormatter TIDFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
							String timeString = LocalDateTime.now().format(TIDFormatter);
							System.out.println("TID: " + showTimeController.read().get(showChoice).getCinema().getNameCode() + "_"+ timeString);
							showTimeController.getSeatingForShowtime(showChoice);
						} else {
							break;
						}
					}


			}

		}
	}
}
