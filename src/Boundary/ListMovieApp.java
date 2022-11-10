package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
import Entity.MovieGoer;

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
	 * @param currentUser The current MovieGoer who is listing movies.
	 */
	public void main(MovieGoer currentUser) {
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
				int reviewChoice = 0;
				while(true){
					System.out.println("Do you want to add a review for the movie " + movieController.getMovieByNo(choice).getTitle() + " ? Enter 1 for yes, 0 for no.");
					reviewChoice = ScannerController.getInputInt();
					if(reviewChoice == 1){
						System.out.println("Please enter your review content: ");
						String reviewContent = ScannerController.getInputString();
						System.out.println("Please enter your review score (1-5)");
						int reviewScore = ScannerController.getInputInt();
						movieController.addReview(movieController.getMovieByNo(choice).getTitle(), currentUser.getUsername(), reviewContent, reviewScore);
						break;
					} else {
						break;
					}
				}
		}
	}
}
