package Boundary;

import Controller.HolidayController;
import Controller.ScannerController;
import Entity.Holidays;

import java.time.LocalDate;
import java.util.ArrayList;

public class EditHolidaysApp {
	public void main(){
		boolean isRunning = true;
		Holidays output = new Holidays();
		HolidayController holidayController = new HolidayController();
		while(isRunning){
			Holidays holidays = holidayController.read();
			System.out.println("List of holidays");

			for(int i=0; i<holidays.getHolidayList().size(); i++){
				System.out.println(i+1 + ". " + holidays.getHolidayList().get(i).toString());
			}
			System.out.println("Do you want to add a holiday? Enter 1 for yes, 0 for no");
			int choice = 0;
			choice = ScannerController.getInputInt();
			if(choice == 1){
				System.out.println("Enter a date for the holiday");
				ArrayList<LocalDate> temp = holidays.getHolidayList();
				temp.add(LocalDate.parse(ScannerController.getInputString()));
				holidays.setHolidayList(temp);
				holidayController.overwriteHolidaysList(holidays);
			} else {
				return;
			}
		}
	}
}
