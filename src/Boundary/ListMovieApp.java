package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
/**
 * Runnable app for MovieGoer to list movies.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-06
 */
public class ListMovieApp {
	MovieController movieController = new MovieController();
	/**
	 * Main runnable function for MovieGoer to list movies.
	 */
	public void main() {
		int choice = 0;
		while(true){
			movieController.getMovieCatalog();
			System.out.println("Enter any movie's number to see more details, enter 0 to exit.");
			choice = ScannerController.getInputInt();
			choice--;
			if(choice == -1) {
				return;
			}
			movieController.getMovieDetailsByNo(choice);
			//TODO ask to add a review
		}
	}
}
