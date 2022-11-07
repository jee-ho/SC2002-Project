package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
import Controller.ShowTimeController;
import Entity.Movie;
import ExceptionPackage.SeatDoesNotExistException;
import ExceptionPackage.SeatOccupiedException;

public class BookSeatsApp {
	MovieController movieController = new MovieController();
	ShowTimeController showTimeController = new ShowTimeController();
	public void main() {
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
							//TODO add user login system to track booking, on new username detection create new account and ask for age.
							//TODO load user age and combine with current showtime date to determine price
							//TODO add current booking to user history, add price to total sales
							System.out.println("Seat booked at " + row + col);
							showTimeController.getSeatingForShowtime(showChoice);
						} else {
							break;
						}
					}


			}

		}
	}
}
