package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
import Controller.ShowTimeController;
/**
 * Runnable app for MovieGoer to check the seating list of a ShowTime.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-06
 */
public class CheckSeatsApp {
	MovieController movieController = new MovieController();
	ShowTimeController showTimeController = new ShowTimeController();

	/**
	 * Main runnable function for MovieGoer to check the seating list of a ShowTime.
	 */
	public void main(){
		int choice = 0;
		while(true){
			movieController.getMovieCatalog();
			System.out.println("Enter any movie's number to see more showtimes, enter 0 to exit.");
			choice = ScannerController.getInputInt();
			choice--;
			if(choice == -1) {
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
			}

		}
	}
}
