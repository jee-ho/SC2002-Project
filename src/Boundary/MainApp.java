package Boundary;

import Controller.CineplexController;
import Controller.ScannerController;
import Entity.*;
import ExceptionPackage.CinemaCodeNameException;
import ExceptionPackage.ExistingCineplexException;
import ExceptionPackage.LessThan3CinemasException;

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
		CineplexController cineplexController= new CineplexController();
		ArrayList<Cinema> tempCinList= new ArrayList<Cinema>();
		SeatList tempSeat = new SeatList();
		tempSeat.printLayout();
		try {
		tempCinList.add(new Cinema("scr1", "ORCHASCRN1", tempSeat));
		tempCinList.add(new Cinema("scr2", "ORCHASCRN2", tempSeat));
		tempCinList.add(new Cinema("scr3", "ORCHASCRN3", tempSeat));
		cineplexController.createCineplex("Orchard Cineplex", tempCinList);
		} catch (LessThan3CinemasException e) {
			throw new RuntimeException(e);
		} catch (ExistingCineplexException e) {
			throw new RuntimeException(e);
		} catch (CinemaCodeNameException e) {
			throw new RuntimeException(e);
		}

		System.out.println(cineplexController.read().get(0).toString());
		cineplexController.renameCineplex("Orchard Cineplex", "New Cineplex");
		System.out.println(cineplexController.read().get(0).toString());


		cineplexController.deleteCineplex("New Cineplex");



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

		boolean isRunning = true;
		while (isRunning) {
			System.out.println("MOBLIMA MOVIE GOER MENU");
			System.out.println("""
					Available actions:
					1. Search/List movie
					2. View movie details
					3. Check seat availability and selection
					4. Book and purchase ticket
					5. View booking history
					6. List top 5 movies by sales or ratings
					7. Exit to main menu
					Enter your selection:\040""");
			switch (ScannerController.getInputInt()) {
				case 1:
					//TODO
					break;
				case 2:
					//TODO
					break;
				case 3:
					//TODO
					break;
				case 4:
					//TODO
					break;
				case 5:
					//TODO
					break;
				case 6:
					//TODO
					break;
				case 7:
					isRunning = false;
					System.out.println("Exiting Movie Goer...");
					break;
				default:
					System.out.println("Please enter a valid selection");
			}
		}

	}

	/**
	 * The user menu for staff login. Asks for admin password with maximum of "wrongCount" tries.
	 * If password is correct, show the user menu for staff actions
	 */
	public static void StaffMenu() {
		String currentPassword = "admin";
		String enteredPassword = "";
		int wrongCount = 3;
		boolean isRunning = true;
		boolean isLoginRunning = true;
		boolean hasAccess = false;
		while (isLoginRunning) {
			System.out.println("MOBLIMA ADMIN STAFF LOGIN");
			while (!(currentPassword.equals(enteredPassword))) {
				System.out.println("Please enter admin password: ");
				enteredPassword = ScannerController.getInputString();
				if (!(currentPassword.equals(enteredPassword))) {
					System.out.println("Wrong password.");
					if (--wrongCount <= 0) {
						System.out.println("Too many tries, exiting to main menu...");
						isLoginRunning = false;
						break;
					}
				} else {
					System.out.println("Access granted.");
					hasAccess = true;
					isLoginRunning = false;
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
						3. Configure system settings (edit admin password)
						4. Exit
						Enter your selection:\040""");
				switch (ScannerController.getInputInt()) {
					case 1:
						//TODO
						break;
					case 2:
						//TODO
						break;
					case 3:
						//TODO
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