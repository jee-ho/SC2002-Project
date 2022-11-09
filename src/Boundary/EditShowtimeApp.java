package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
import Controller.ShowTimeController;
import Entity.ShowTime;
import ExceptionPackage.ExistingShowtimeException;
import ExceptionPackage.NoSuchMovieException;

import java.time.LocalDateTime;

/**
 * Runnable app for Staff to edit ShowTimes.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public class EditShowtimeApp {
	ShowTimeController showTimeController = new ShowTimeController();
	MovieController movieController = new MovieController();
	/**
	 * Main runnable function for Staff to edit ShowTimes.
	 */
	public void main(){
		int choice = 0;
		while(true){
			System.out.println("Enter a movie's number to see showtimes, enter 0 to exit");
			movieController.getFullMovieCatalog();
			choice = ScannerController.getInputInt();
			choice--;
			if(choice == -1){
				return;
			}
			System.out.println("List of showtimes for " + movieController.getMovieByNo(choice).getTitle());
			showTimeController.getAllShowTimesForMovie(movieController.getMovieByNo(choice).getTitle());
			while(true){
				int showChoice = 0;
				System.out.println("Enter any showtime's number to edit showtime details, enter 0 to exit.");
				showChoice = ScannerController.getInputInt();
				showChoice--;
				if(showChoice == -1){
					break;
				}
				ShowTime tempShowtime = showTimeController.getShowTimeByNo(showChoice);
				System.out.println("Editing showtime");
				System.out.println(tempShowtime.toString());
				showTimeController.deleteShowtime(tempShowtime.getMovie().getTitle(), tempShowtime.getShowTime(), tempShowtime.getCinema().getNameCode());

				System.out.println("Enter new movie name for showtime");
				String movieName = ScannerController.getInputString();
				System.out.println("Enter new time for showtime");
				LocalDateTime time = LocalDateTime.parse(ScannerController.getInputString());
				System.out.println("Enter new cinema name for showtime");
				String cinemaName = ScannerController.getInputString();
				try {
					showTimeController.createShowtime(movieName, time, cinemaName);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
