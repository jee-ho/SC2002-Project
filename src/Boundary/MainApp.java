package Boundary;

import Controller.*;
import Entity.*;
import ExceptionPackage.ExistingUserException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This is the main class.
 * @author Tan Chuan Liang
 * @version 1.1
 * @since 2022-10-30
 */
class MainApp {
	/**
	 * The main menu. Shows choices for type of user (Movie Goer or Admin Staff)
	 *
	 * @param args The arguments passed into main.
	 */
	public static void main(String[] args) {
		CineplexController cineplexController = new CineplexController();
		SeatListController seatListController = new SeatListController();
		MovieController movieController = new MovieController();
		ShowTimeController showTimeController = new ShowTimeController();
		UserController userController = new UserController();
		TicketPriceController ticketPriceController = new TicketPriceController();
		HolidayController holidayController = new HolidayController();

		ArrayList<Cinema> tempCinList= new ArrayList<Cinema>();
		try{

			tempCinList.add(new Cinema("scr1", "ORCHASCRN1"));
			tempCinList.add(new Cinema("scr2", "ORCHASCRN2"));
			tempCinList.add(new Cinema("scr3", "ORCHASCRN3"));
			cineplexController.createCineplex("Orchard Cineplex", tempCinList);


			System.out.println(cineplexController.read().get(0).toString());


			movieController.addMovie("Jaws", Movie.ShowStatus.NOWSHOWING, "Shark eats man", "Steven Spielberg",
					new String[]{"Roy Scheider", "Robert Shaw", "Richard Dreyluss"}, Movie.MovieType.TYPE_REGULAR, 124, Movie.MovieRating.PG);

			movieController.addMovie("Jaws 2", Movie.ShowStatus.NOWSHOWING, "Shark eats man", "Steven Spielberg",
					new String[]{"Roy Scheider", "Robert Shaw", "Richard Dreyluss"}, Movie.MovieType.TYPE_BLOCKBUSTER, 124, Movie.MovieRating.PG13);

			movieController.addReview("Jaws", "TCL","good",4);
			movieController.addReview("Jaws", "KEK","bad",2);

			System.out.println(movieController.read().get(0).toString());


			showTimeController.createShowtime("Jaws", LocalDateTime.parse("2022-12-03T10:15:30"), "ORCHASCRN1");
			showTimeController.createShowtime("Jaws 2", LocalDateTime.parse("2022-12-03T19:15:30"), "ORCHASCRN1");

			System.out.println(showTimeController.read().get(0).toString());

			//ShowTime tempsho = showTimeController.getShowTime("Jaws", LocalDateTime.parse("2022-12-03T10:15:30"), "ORCHASCRN1");
			//showTimeController.updateSeatList(tempsho, seatListController.bookSeat(tempsho.getShowSeatPlan(),'A',12));

			//ShowTime tempsho2 = showTimeController.getShowTime("Jaws 2", LocalDateTime.parse("2022-12-03T19:15:30"), "ORCHASCRN1");
			//showTimeController.updateSeatList(tempsho2, seatListController.bookSeat(tempsho2.getShowSeatPlan(),'B',2));
			showTimeController.updateSeatStatus(showTimeController.read().get(1), showTimeController.read().get(1).getShowSeatPlan().bookSeat('B', 2));

			movieController.changeMovieStatus("Jaws", Movie.ShowStatus.ENDOFSHOWING);


			//seatListController.printLayout(tempsho.getShowSeatPlan());
			//seatListController.printLayout(tempsho2.getShowSeatPlan());
			showTimeController.getSeatingForShowtime(1);
			//showTimeController.getSeatingForShowtime(1);

			movieController.getMovieCatalog();

			showTimeController.getAllShowTimesForMovie("Jaws");

			System.out.println(showTimeController.getShowTime("Jaws", LocalDateTime.parse("2022-12-03T10:15:30"), "ORCHASCRN1").getMovie().toString());


			try {
				userController.addStaff("admin", "admin");
				userController.addMovieGoer("watcher", "password", "Tan CL", 91234567, "a@b.com", 22);
			} catch (ExistingUserException e) {
				System.out.println(e.getMessage());
			}

			System.out.println(userController.read().get(0));

			ticketPriceController.initialisePricesList();
			holidayController.initialiseHolidays();

			System.out.println("End of init");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}



		boolean isRunning = true;
		while (isRunning) {
			System.out.println("MOBLIMA MAIN MENU");
			System.out.println("""
					Available actions:
					1. Movie Goer login
					2. Admin Staff login
					3. Exit application
					Enter your selection:\040""");
			switch (ScannerController.getInputInt()) {
				case 1 -> MovieGoerMenu();
				case 2 -> StaffMenu();
				case 3 -> {
					//showTimeController.deleteShowtime("Jaws", LocalDateTime.parse("2022-12-03T10:15:30"), "ORCHASCRN1");
					//showTimeController.deleteShowtime("Jaws 2", LocalDateTime.parse("2022-12-03T19:15:30"), "ORCHASCRN1");

					//movieController.deleteMovie("Jaws");
					//movieController.deleteMovie("Jaws 2");

					//cineplexController.deleteCineplex("Orchard Cineplex");
					isRunning = false;
					System.out.println("Exiting...");
				}
				default -> System.out.println("Please enter a valid selection");
			}
		}
		ScannerController.closeScanner();
	}

	/**
	 * The user menu for Movie Goer login. Shows user menu for Movie Goer actions.
	 */
	public static void MovieGoerMenu() {
		UserController userController = new UserController();
		int wrongCount = 3;
		boolean isRunning = true;
		boolean isLoginRunning = true;
		boolean hasAccess = false;
		String tempUsername = "";
		String tempPassword = "";
		MovieGoer currentUser = null;
		while (isLoginRunning) {
			System.out.println("MOBLIMA MOVIE GOER LOGIN");
			System.out.println("Please enter username: ");
			tempUsername = ScannerController.getInputString();
			System.out.println("Please enter password: ");
			tempPassword = ScannerController.getInputString();
			if(userController.isValidLogin(tempUsername, tempPassword) && !(userController.isStaff(tempUsername))) {
				currentUser = (MovieGoer) userController.getUserByUsername(tempUsername);
				System.out.println("Access granted.");
				hasAccess = true;
				isLoginRunning = false;
			} else {
				System.out.println("Wrong username or password");
				if(--wrongCount <= 0){
					System.out.println("Too many tries, exiting to main menu...");
					isLoginRunning = false;
					break;
				}
			}
		}
		if(hasAccess){
			while (isRunning) {
				System.out.println("MOBLIMA MOVIE GOER MENU");
				System.out.println("""
					Available actions:
					1. List movies & view movie details
					2. Check showtimes and seat availability
					3. Book and purchase ticket
					4. View booking history
					5. List top 5 movies by sales or ratings
					6. Exit to main menu
					Enter your selection:\040""");
				switch (ScannerController.getInputInt()) {
					case 1:
						ListMovieApp lma = new ListMovieApp();
						lma.main();
						break;
					case 2:
						CheckSeatsApp csa = new CheckSeatsApp();
						csa.main();
						break;
					case 3:
						BookSeatsApp bsa = new BookSeatsApp();
						bsa.main(currentUser);
						break;
					case 4:
						//TODO view booking history
						break;
					case 5:
						//TODO list movie by sale/rating. linked to admin setting.
						break;
					case 6:
						isRunning = false;
						System.out.println("Exiting Movie Goer...");
						break;
					default:
						System.out.println("Please enter a valid selection");
				}
			}
		}
	}

	/**
	 * The user menu for staff login. Asks for admin password with maximum of "wrongCount" tries.
	 * If password is correct, show the user menu for staff actions
	 */
	public static void StaffMenu() {
		UserController userController = new UserController();
		int wrongCount = 3;
		boolean isRunning = true;
		boolean isLoginRunning = true;
		boolean hasAccess = false;
		String tempUsername = "";
		String tempPassword = "";
		while (isLoginRunning) {
			System.out.println("MOBLIMA ADMIN STAFF LOGIN");
			System.out.println("Please enter username: ");
			tempUsername = ScannerController.getInputString();
			System.out.println("Please enter password: ");
			tempPassword = ScannerController.getInputString();
			if(userController.isValidLogin(tempUsername, tempPassword) && userController.isStaff(tempUsername)) {
				System.out.println("Access granted.");
				hasAccess = true;
				isLoginRunning = false;
			} else {
				System.out.println("Wrong username or password, or not admin account");
				if(--wrongCount <= 0){
				System.out.println("Too many tries, exiting to main menu...");
				isLoginRunning = false;
				break;
				}
			}
		}

		if (hasAccess) {
			while (isRunning) {
				System.out.println("MOBLIMA ADMIN STAFF MENU");
				System.out.println("""
						Available actions:
						1. Create/Update/Remove movie listing
						2. Create/Update/Remove show times and movies
						3. Configure system settings
						4. Exit
						Enter your selection:\040""");
				switch (ScannerController.getInputInt()) {
					case 1:
						EditMovieApp ema = new EditMovieApp();
						ema.main();
						break;
					case 2:
						EditShowtimeApp esa = new EditShowtimeApp();
						esa.main();
						break;
					case 3:
						SystemSettingsApp ssa = new SystemSettingsApp();
						ssa.main();
						break;
					case 4:
						isRunning = false;
						System.out.println("Exiting Admin Staff...");
						break;
					default:
						System.out.println("Please enter a valid selection");
				}
			}
		}
	}
}