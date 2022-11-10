package Boundary;

import Controller.ScannerController;
import Controller.SystemSettingsController;

/**
 * Runnable app for Staff to edit the mode of top movies listing (sales or reviews).
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-10
 */
public class EditMovieDisplayApp {
	/**
	 * Main runnable function for Staff to edit the mode of top movies listing (sales or reviews).
	 */
	public void main(){
		SystemSettingsController systemSettingsController = new SystemSettingsController();
		System.out.println("Enter 0 to set top movie listing by sales, Enter 1 to set top movie listing by reviews");
		int choice = 0;
		choice = ScannerController.getInputInt();
		if(choice == 0){
			System.out.println("Set top movie listing to by sales");
			systemSettingsController.setMovieDisplayToggle(0);
		} else if (choice == 1) {
			System.out.println("Set top movie listing to by reviews");
			systemSettingsController.setMovieDisplayToggle(1);
		} else {
			//
		}


	}
}
