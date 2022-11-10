package Controller;

import Entity.Movie;
import Entity.Review;
import ExceptionPackage.ExistingMovieException;

import java.io.*;
import java.util.ArrayList;
/**
 * Controller for interfacing with Movie objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class MovieController {
	public final static String FILENAME = "movies.txt";

	/**
	 * Adds a movie to the movie data file.
	 * @param title Title of movie.
	 * @param status Showing status of movie (preview, nowshowing, comingsoon, endofshowing).
	 * @param synopsis Synopsis of movie.
	 * @param director Director of movie.
	 * @param cast Cast of movie.
	 * @param type Type of movie (type_regular, type_3d, type_blockbuster).
	 * @param duration Duration of movie in minutes.
	 * @param rating Censorship rating of movie (G, PG13, PG, NC16, M18, R21)
	 * @throws ExistingMovieException Cannot add if there is an existing movie with the same name.
	 */
	public void addMovie(String title, Movie.ShowStatus status, String synopsis, String director, String[] cast, Movie.MovieType type, int duration, Movie.MovieRating rating) throws ExistingMovieException {
		File data = new File(FILENAME);
		ArrayList<Movie> movies = new ArrayList<Movie>();
		if(data.exists()){
			movies = read();
			if(movies.size()!=0){
				for (Movie movie : movies) {
					if (movie.getTitle().equals(title)) {
						throw new ExistingMovieException();
					}
				}
			}

		}

		Movie movieToBeAdded = new Movie(title, status, synopsis, director, cast, type, duration, rating);

		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			movies.add(movieToBeAdded);
			outputStream.writeObject(movies);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("caught on add movie");
		}
	}

	/**
	 * Reads from the movies data file
	 * @return ArrayList of Movies from data file.
	 */
	public ArrayList<Movie> read() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			ArrayList<Movie> MovieList = (ArrayList<Movie>) inputStream.readObject();
			inputStream.close();
			return MovieList;
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<Movie>();
		}

	}

	/**
	 * Deletes a movie by title from the data file.
	 * @param searchName Title of movie to delete.
	 */
	public void deleteMovie(String searchName){
		ArrayList<Movie> movies = read();
		ArrayList<Movie> returnList = new ArrayList<Movie>();

		for (Movie mov : movies) {
			if (!(mov.getTitle().equals(searchName))) {
				returnList.add(mov);
			}
		}
		overwriteMovieList(FILENAME, returnList);

	}

	/**
	 * Overwrites the movie data file.
	 * @param filename Filename of movie data file.
	 * @param data ArrayList of Movie to overwrite with.
	 */
	private void overwriteMovieList(String filename, ArrayList<Movie> data){
		File temp = new File(filename);
		if(temp.exists()){
			temp.delete();
		}
		try{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			outputStream.writeObject(data);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e){
			System.out.println("caught in moviecontroller");
		}
	}

	/**
	 * Add a review to a movie by its title.
	 * @param movieName Title of movie to add review to.
	 * @param author Username of MovieGoer adding the review.
	 * @param reviewText Content of review.
	 * @param reviewScore Numerical score of review (1-5).
	 */
	public void addReview(String movieName, String author, String reviewText, int reviewScore){
		File data = new File(FILENAME);
		ArrayList<Movie> movies;
		if(data.exists()){
			movies = read();
			if(movies.size()!=0){
				for (Movie movie : movies) {
					if (movie.getTitle().equals(movieName)) {
						Review tempReview = new Review(author, reviewText, reviewScore);
						ArrayList<Review> reviews;
						reviews = movie.getReviews();
						reviews.add(tempReview);
						movie.setReviews(reviews);
						overwriteMovieList(FILENAME, movies);

						//Calculate overallReviewScore
						double reviewScoreSum = 0.0;
						for(Review review : reviews){
							reviewScoreSum += review.getReviewScore();
						}
						double reviewScoreAvg = reviewScoreSum / reviews.size();
						if(reviews.size() <= 1){
							movie.setOverallReviewScore(0.0);
						} else {
							movie.setOverallReviewScore(reviewScoreAvg);
						}
						ShowTimeController stc = new ShowTimeController();
						stc.updateMovieStatus(movie);
						overwriteMovieList(FILENAME, movies);

					}
				}
			}

		}

	}

	/**
	 * Changes the movie's status.
	 * @param searchName Title of movie.
	 * @param status Status of movie to change to.
	 */
	public void changeMovieStatus(String searchName, Movie.ShowStatus status) {
		File data = new File(FILENAME);
		ArrayList<Movie> movies;
		if(data.exists()){
			movies = read();
			if(movies.size()!=0){
				for (Movie movie : movies) {
					if (movie.getTitle().equals(searchName)) {
						movie.setStatus(status);

						ShowTimeController stc = new ShowTimeController();
						stc.updateMovieStatus(movie);

						overwriteMovieList(FILENAME, movies);
					}
				}
			}
		}
	}

	/**
	 * Adds to the total earnings of a movie.
	 * @param searchName Title of movie.
	 * @param earning Amount to be added.
	 */
	public void addMovieEarning(String searchName, double earning) {
		File data = new File(FILENAME);
		ArrayList<Movie> movies;
		if(data.exists()){
			movies = read();
			if(movies.size()!=0){
				for (Movie movie : movies) {
					if (movie.getTitle().equals(searchName)) {
						movie.setTotalSales(movie.getTotalSales() + earning);

						ShowTimeController stc = new ShowTimeController();
						stc.updateMovieStatus(movie);

						overwriteMovieList(FILENAME, movies);
					}
				}
			}
		}
	}

	/**
	 * Get a movie by its title.
	 * @param searchName Title of movie.
	 * @return Movie object with this title.
	 */
	public Movie getMovieByName(String searchName){
		ArrayList<Movie> tempMovieList = read();
		for(Movie mov : tempMovieList){
			if(mov.getTitle().equals(searchName)){
				return mov;
			}
		}
		return null;
	}

	/**
	 * Prints the full movie catalog (excluding endofshowing) according to data file order.
	 */
	public void getMovieCatalog(){
		ArrayList<Movie> tempMovieList = read();
		int i = 1;
		for(Movie mov : tempMovieList){
			if(mov.getStatus() != Movie.ShowStatus.ENDOFSHOWING){
				System.out.println(i + ": " + mov.getTitle() + " (" +mov.getRating() + ")");
			}
			i++;
		}
	}

	/**
	 * Prints the full movie catalog (including endofshowing) according to data file order.
	 */
	public void getFullMovieCatalog(){
		ArrayList<Movie> tempMovieList = read();
		int i = 1;
		for(Movie mov : tempMovieList){
			System.out.println(i + ": " + mov.getTitle() + " (" +mov.getRating() + ")");
			i++;
		}
	}


	/**
	 * Prints details of a Movie by data file index number.
	 * @param i Index number of Movie.
	 */
	public void getMovieDetailsByNo(int i) {
		ArrayList<Movie> tempMovieList = read();
		Movie mov = tempMovieList.get(i);
		System.out.println(mov.toString());
	}

	/**
	 * Gets the Movie object by data file index number.
	 * @param i Index number of Movie.
	 * @return Movie object with this index number.
	 */
	public Movie getMovieByNo(int i){
		ArrayList<Movie> tempMovieList = read();
		return tempMovieList.get(i);
	}
}
