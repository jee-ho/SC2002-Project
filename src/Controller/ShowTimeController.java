package Controller;

import Entity.Movie;
import Entity.SeatList;
import Entity.ShowTime;
import ExceptionPackage.ExistingShowtimeException;
import ExceptionPackage.NoSuchCinemaException;
import ExceptionPackage.NoSuchMovieException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Controller for interfacing with ShowTime objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public class ShowTimeController {
	public final static String FILENAME = "showtimes.txt";

	/**
	 * Create a new ShowTime.
	 * @param movieName Movie to be screened.
	 * @param time Date and time of screening.
	 * @param cinemaName Codename of cinema where screening is occurring.
	 * @throws ExistingShowtimeException New ShowTime cannot be same signature as an existing one.
	 * @throws NoSuchMovieException Movie must exist in database to be added to ShowTime.
	 */
	public void createShowtime(String movieName, LocalDateTime time, String cinemaName) throws ExistingShowtimeException, NoSuchMovieException {
		File data = new File(FILENAME);
		ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
		if(data.exists()){
			showtimes = read();
			if(showtimes.size()!=0){
				for (ShowTime showtime : showtimes) {
					if (showtime.getMovie().getTitle().equals(movieName) && showtime.getShowTime().isEqual(time) && showtime.getCinema().getNameCode().equals(cinemaName)) {
						throw new ExistingShowtimeException();
					}
				}
			}

		}

		try {
			MovieController movcon = new MovieController();
			CineplexController cinecon = new CineplexController();
			if(movcon.getMovieByName(movieName) == null){
				throw new NoSuchMovieException();
			}
			if(cinecon.getCinemaByCodeName(cinemaName) == null){
				throw new NoSuchCinemaException();
			}
			ShowTime showTimeToBeAdded = new ShowTime(movcon.getMovieByName(movieName), time, cinecon.getCinemaByCodeName(cinemaName));
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			showtimes.add(showTimeToBeAdded);
			outputStream.writeObject(showtimes);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Read the ShowTime data file.
	 * @return ArrayList of ShowTimes in data file.
	 */
	public ArrayList<ShowTime> read() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
			ArrayList<ShowTime> showTimeList = (ArrayList<ShowTime>) inputStream.readObject();
			inputStream.close();
			return showTimeList;
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<ShowTime>();
		}

	}

	/**
	 * Delete a ShowTime from datafile.
	 * @param movieName Movie to be screened.
	 * @param time Date and time of screening.
	 * @param cinemaName Codename of cinema where screening is occurring.
	 */
	public void deleteShowtime(String movieName, LocalDateTime time, String cinemaName){
		ArrayList<ShowTime> showTimes = read();
		ArrayList<ShowTime> returnList = new ArrayList<ShowTime>();

		for (ShowTime sho : showTimes) {
			if (!(sho.getMovie().getTitle().equals(movieName) && sho.getShowTime().isEqual(time) && sho.getCinema().getNameCode().equals(cinemaName))) {
				returnList.add(sho);
			}
		}
		overwriteShowtimeList(FILENAME, returnList);

	}

	/**
	 * Overwrite a ShowTime's details in data file.
	 * @param filename Filename of ShowTime data file.
	 * @param data ShowTime details to be overwritten.
	 */
	private void overwriteShowtimeList(String filename, ArrayList<ShowTime> data){
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
			System.out.println("caught in showTimecontroller");
		}
	}

	/**
	 * Get a ShowTime from ShowTime data file
	 * @param movieName Movie to be screened.
	 * @param time Date and time of screening.
	 * @param cinemaName Codename of cinema where screening is occurring.
	 * @return ShowTime with this signature.
	 */
	public ShowTime getShowTime(String movieName, LocalDateTime time, String cinemaName){
		ArrayList<ShowTime> showTimes = read();
		for (ShowTime sho : showTimes) {
			if (sho.getMovie().getTitle().equals(movieName) && sho.getShowTime().isEqual(time) && sho.getCinema().getNameCode().equals(cinemaName)) {
				return sho;
			}
		}
		return null;
	}

	/**
	 * Get a ShowTime from ShowTime data file according to its int position in file.
	 * @param i Int position in file.
	 * @return ShowTime with this position.
	 */
	public ShowTime getShowTimeByNo(int i){
		ArrayList<ShowTime> showTimes = read();
		return showTimes.get(i);
	}

	/**
	 * Get all ShowTimes for a given Movie.
	 * @param movieName Name of movie.
	 * @return ArrayList of ShowTimes screening this Movie.
	 */
	public ArrayList<ShowTime> getAllShowTimesForMovie(String movieName){
		ArrayList<ShowTime> showTimes = read();
		int i = 1;
		for(ShowTime sho : showTimes) {
			if(sho.getMovie().getTitle().equals(movieName)){
				System.out.println( i+ ": " + sho.getShowTime().toLocalDate() +" " +sho.getShowTime().toLocalTime()+ " at " + sho.getCinema().getNameCode());
			}
			i++;
		}
		return showTimes;
	}

	/**
	 * Print the seating list for a ShowTime according to its int position in file.
	 * @param i Int position in data file.
	 */
	public void getSeatingForShowtime(int i){
		ArrayList<ShowTime> showTimes = read();
		ShowTime sho = showTimes.get(i);
		SeatListController seatListController = new SeatListController();
		System.out.println("Seating plan for " + sho.getShowTime().toLocalDate() +" " +sho.getShowTime().toLocalTime()+ " at " + sho.getCinema().getNameCode());
		seatListController.printLayout(sho.getShowSeatPlan());
	}


	/**
	 * Update the movie for a ShowTime. Needed to ensure data consistency between Movie and ShowTime.
	 * @param movie Movie to overwrite in ShowTime.
	 */
	public void updateMovieStatus(Movie movie){
		File data2 = new File(FILENAME);
		ArrayList<ShowTime> showtimes;
		if(data2.exists()){
			showtimes = read();
			if(showtimes.size()!=0){
				for (ShowTime sho : showtimes) {
					if (sho.getMovie().getTitle().equals(movie.getTitle())) {
						sho.setMovie(movie);
						overwriteShowtimeList(FILENAME, showtimes);
					}
				}
			}

		}
	}

	/**
	 * Update the seating list for a ShowTime.
	 * @param show ShowTime to update.
	 * @param seats New SeatList to overwrite with.
	 */
	public void updateSeatStatus(ShowTime show, SeatList seats){
		File data2 = new File(FILENAME);
		ArrayList<ShowTime> showtimes;
		if(data2.exists()){
			showtimes = read();
			if(showtimes.size()!=0){
				for (ShowTime sho : showtimes) {
					if (sho.getMovie().getTitle().equals(show.getMovie().getTitle()) && sho.getShowTime().isEqual(show.getShowTime()) && sho.getCinema().getNameCode().equals(show.getCinema().getNameCode())) {
						sho.setShowSeatPlan(seats);
						overwriteShowtimeList(FILENAME, showtimes);
					}
				}
			}

		}
	}


}
