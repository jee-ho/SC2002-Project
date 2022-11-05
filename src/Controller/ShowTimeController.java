package Controller;

import Entity.Cinema;
import Entity.Movie;
import Entity.SeatList;
import Entity.ShowTime;
import ExceptionPackage.ExistingShowtimeException;
import ExceptionPackage.NoSuchCinemaException;
import ExceptionPackage.NoSuchMovieException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShowTimeController {
	public final static String FILENAME = "showtimes.txt";

	public void createShowtime(String movieName, LocalDateTime time, String cinemaName) throws ExistingShowtimeException, NoSuchMovieException {
		File data = new File(FILENAME);
		ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
		if(data.exists()){
			showtimes = read();
			if(showtimes.size()!=0){
				for (ShowTime showtime : showtimes) {
					if (showtime.getMovie().getTitle().equals(movieName) && showtime.getShowTime().equals(time) && showtime.getCinema().getNameCode().equals(cinemaName)) {
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
	public void deleteShowtime(String movieName, LocalDateTime time){
		ArrayList<ShowTime> showTimes = read();
		ArrayList<ShowTime> returnList = new ArrayList<ShowTime>();

		for (ShowTime sho : showTimes) {
			if (!(sho.getMovie().getTitle().equals(movieName) && sho.getShowTime().equals(time))) {
				returnList.add(sho);
			}
		}
		overwriteShowtimeList(FILENAME, returnList);

	}

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

	public ShowTime getShowTime(String movieName, LocalDateTime time, String cinemaName){
		ArrayList<ShowTime> showTimes = read();
		for (ShowTime sho : showTimes) {
			if (sho.getMovie().getTitle().equals(movieName) && sho.getShowTime().equals(time) && sho.getCinema().getNameCode().equals(cinemaName)) {
				return sho;
			}
		}
		return null;
	}

	public void getAllShowTimesForMovie(String movieName){
		ArrayList<ShowTime> showTimes = read();
		int i = 1;
		for(ShowTime sho : showTimes) {
			if(sho.getMovie().getTitle().equals(movieName)){
				System.out.println( i+ ": " + sho.getShowTime().toLocalDate() +" " +sho.getShowTime().toLocalTime()+ " at " + sho.getCinema().getNameCode());
			}
			i++;
		}
	}

	public void getSeatingForShowtime(int i){
		ArrayList<ShowTime> showTimes = read();
		ShowTime sho = showTimes.get(i);
		SeatListController seatListController = new SeatListController();
		System.out.println("Seating plan for " + sho.getShowTime().toLocalDate() +" " +sho.getShowTime().toLocalTime()+ " at " + sho.getCinema().getNameCode());
		seatListController.printLayout(sho.getShowSeatPlan());
	}

	public void updateSeatList(ShowTime showtime, SeatList seatList){
		ArrayList<ShowTime> showTimes = read();
		ArrayList<ShowTime> returnList = new ArrayList<ShowTime>();

		for (ShowTime sho : showTimes) {
			if (sho.getMovie() == showtime.getMovie() && sho.getShowTime() == showtime.getShowTime() && sho.getCinema().getNameCode().equals(showtime.getCinema().getNameCode()) ){
				sho.setShowSeatPlan(seatList);
				returnList.add(sho);
			} else {
				returnList.add(sho);
			}
		}
		overwriteShowtimeList(FILENAME, returnList);
	}
}
