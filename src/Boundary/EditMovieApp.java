package Boundary;

import Controller.MovieController;
import Controller.ScannerController;
import Entity.Movie;
import ExceptionPackage.ExistingMovieException;

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
		int choice = 0;
		Movie tempMovie;
		while(true){
			System.out.println("Enter a movie's number to edit, enter 0 to exit");
			movieController.getFullMovieCatalog();
			choice = ScannerController.getInputInt();
			choice--;
			if(choice == -1){
				return;
			}
			System.out.println("Editing movie: ");
			System.out.println(movieController.getMovieByNo(choice).toString());
			movieController.deleteMovie(movieController.getMovieByNo(choice).getTitle());

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
			Movie.MovieType type =  Movie.MovieType.valueOf("TYPE_"+ScannerController.getInputString().toUpperCase());
			System.out.println("Enter new duration");
			int duration = ScannerController.getInputInt();
			System.out.println("Enter movie rating");
			Movie.MovieRating rating = Movie.MovieRating.valueOf(ScannerController.getInputString().toUpperCase());
			try {
				movieController.addMovie(title, status, synopsis, director, cast, type, duration, rating);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
