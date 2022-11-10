package Boundary;

import Controller.ScannerController;

import java.io.Serializable;

/**
 * Runnable app for Staff to edit system settings.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-09
 */
public class SystemSettingsApp implements Serializable {
	/**
	 * Main runnable function for Staff to edit system settings.
	 */
	public void main(){
		boolean isRunning = true;
		while(isRunning){
			System.out.println("ADMIN SYSTEM SETTINGS MENU");
			System.out.println("Available actions: ");
			System.out.println("1. Edit holidays");
			System.out.println("2. Edit ticket prices");
			System.out.println("3. Choose display mode of top movies");
			System.out.println("4. Exit");
			switch (ScannerController.getInputInt()){
				case 1:
					EditHolidaysApp eha = new EditHolidaysApp();
					eha.main();
					break;
				case 2:
					EditPricesApp epa = new EditPricesApp();
					epa.main();
					break;
				case 3:
					EditMovieDisplayApp emd = new EditMovieDisplayApp();
					emd.main();
					break;
				case 4:
					return;
			}
		}
	}
}
