package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
import Entity.Movie;

/**
 * Runnable app for Staff to edit movies.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public class EditMovieApp {
	MovieController movieController = new MovieController();
	/**
	 * Main runnable function for Staff to edit movies.
	 */
	public void main(){
		while(true){
			System.out.println("MOBLIMA ADMIN STAFF MOVIE LISTING MENU");
			System.out.println("""
						Available actions:
						1. Create movie listing
						2. Update movie listing
						3. Remove movie listing
						4. Change movie's status to End of Showing
						5. Exit
						Enter your selection:\040""");
			switch (ScannerController.getInputInt()) {
				case 1:
					System.out.println("Creating movie: ");

					System.out.println("Enter new name");
					String title = ScannerController.getInputString();
					System.out.println("Enter new status");
					Movie.ShowStatus status = Movie.ShowStatus.valueOf(ScannerController.getInputString().toUpperCase());
					System.out.println("Enter new synopsis");
					String synopsis = ScannerController.getInputString();
					System.out.println("Enter new director");
					String director = ScannerController.getInputString();
					System.out.println("Enter new cast, separated by commas");
					String[] cast = ScannerController.getInputString().split(",");
					System.out.println("Enter new movie type");
					Movie.MovieType type = Movie.MovieType.valueOf("TYPE_" + ScannerController.getInputString().toUpperCase());
					System.out.println("Enter new duration");
					int duration = ScannerController.getInputInt();
					System.out.println("Enter movie rating");
					Movie.MovieRating rating = Movie.MovieRating.valueOf(ScannerController.getInputString().toUpperCase());
					try {
						movieController.addMovie(title, status, synopsis, director, cast, type, duration, rating);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					int choice;
					System.out.println("Enter a movie's number to edit, enter 0 to exit");
					movieController.getFullMovieCatalog();
					choice = ScannerController.getInputInt();
					choice--;
					if (choice == -1) {
						return;
					}
					System.out.println("Editing movie: ");
					System.out.println(movieController.getMovieByNo(choice).toString());
					movieController.deleteMovie(movieController.getMovieByNo(choice).getTitle());

					System.out.println("Enter new name");
					String editTitle = ScannerController.getInputString();
					System.out.println("Enter new status");
					Movie.ShowStatus editStatus = Movie.ShowStatus.valueOf(ScannerController.getInputString().toUpperCase());
					System.out.println("Enter new synopsis");
					String editSynopsis = ScannerController.getInputString();
					System.out.println("Enter new director");
					String editDirector = ScannerController.getInputString();
					System.out.println("Enter new cast, separated by commas");
					String[] editCast = ScannerController.getInputString().split(",");
					System.out.println("Enter new movie type");
					Movie.MovieType editType = Movie.MovieType.valueOf("TYPE_" + ScannerController.getInputString().toUpperCase());
					System.out.println("Enter new duration");
					int editDuration = ScannerController.getInputInt();
					System.out.println("Enter movie rating");
					Movie.MovieRating editRating = Movie.MovieRating.valueOf(ScannerController.getInputString().toUpperCase());
					try {
						movieController.addMovie(editTitle, editStatus, editSynopsis, editDirector, editCast, editType, editDuration, editRating);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					int delChoice;
					System.out.println("Enter a movie's number to delete, enter 0 to exit");
					movieController.getFullMovieCatalog();
					delChoice = ScannerController.getInputInt();
					delChoice--;
					if (delChoice == -1) {
						return;
					}
					System.out.println("Deleting movie: ");
					System.out.println(movieController.getMovieByNo(delChoice).toString());
					movieController.deleteMovie(movieController.getMovieByNo(delChoice).getTitle());
					break;
				case 4:
					int endChoice;
					System.out.println("Enter a movie's number to set to End of Showing, enter 0 to exit");
					movieController.getFullMovieCatalog();
					endChoice = ScannerController.getInputInt();
					endChoice--;
					if (endChoice == -1) {
						return;
					}
					movieController.changeMovieStatus(movieController.getMovieByNo(endChoice).getTitle(), Movie.ShowStatus.ENDOFSHOWING);
					System.out.println("Movie set to End of Showing: ");
					System.out.println(movieController.getMovieByNo(endChoice).toString());
				case 5:
					return;
			}
		}
	}
}
