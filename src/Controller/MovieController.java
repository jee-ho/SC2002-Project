package Controller;

import Entity.Movie;
import Entity.Review;
import Entity.ShowTime;
import ExceptionPackage.ExistingMovieException;

import java.io.*;
import java.util.ArrayList;

public class MovieController {
	public final static String FILENAME = "movies.txt";
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
					}
				}
			}

		}

	}

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

	public Movie getMovieByName(String searchName){
		ArrayList<Movie> tempMovieList = read();
		for(Movie mov : tempMovieList){
			if(mov.getTitle().equals(searchName)){
				return mov;
			}
		}
		return null;
	}

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




	public void getMovieDetailsByNo(int i) {
		ArrayList<Movie> tempMovieList = read();
		Movie mov = tempMovieList.get(i);
		System.out.println(mov.toString());
	}

	public Movie getMovieByNo(int i){
		ArrayList<Movie> tempMovieList = read();
		return tempMovieList.get(i);
	}
}
