package Boundary;

import Controller.ScannerController;
import Controller.TicketPriceController;
import Entity.TicketPrice;
/**
 * Runnable app for Staff to edit ticket prices.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-09
 */
public class EditPricesApp {
	/**
	 * Main runnable function for Staff to edit ticket prices.
	 */
	public void main(){
		boolean isRunning = true;
		TicketPriceController ticketPriceController = new TicketPriceController();
		while(isRunning){
			TicketPrice ticketPrice = ticketPriceController.read();
			System.out.println("Choose a ticket price to edit, or enter 0 to exit:");
			System.out.println("1. Senior Citizen Weekday " + ticketPrice.getSeniorCitizenWeekday());
			System.out.println("2. Student Weekday " + ticketPrice.getStudentWeekday());
			System.out.println("3. Student Weekday 3D " + ticketPrice.getStudentWeekday3D());
			System.out.println("4. Mon-Wed " + ticketPrice.getMonWed());
			System.out.println("5. Mon-Wed 3D " + ticketPrice.getMonWed3D());
			System.out.println("6. Thu " + ticketPrice.getThu());
			System.out.println("7. Thu 3D " + ticketPrice.getThu3D());
			System.out.println("8. Fri Afternoon " + ticketPrice.getFriAft());
			System.out.println("9. Fri Afternoon 3D " + ticketPrice.getFriAft3D());
			System.out.println("10. Fri Evening " + ticketPrice.getFriEve());
			System.out.println("11. Fri Evening 3D " + ticketPrice.getFriEve3D());
			System.out.println("12. Weekend " + ticketPrice.getWeekend());
			System.out.println("13. Weekend 3D " + ticketPrice.getWeekend3D());
			System.out.println("14. Preferred credit/loyalty card " + ticketPrice.getCard());
			switch (ScannerController.getInputInt()){
				case 0:
					return;
				case 1:
					System.out.println("Enter new Senior Citizen Weekday price");
					ticketPrice.setSeniorCitizenWeekday(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 2:
					System.out.println("Enter new Student Weekday price");
					ticketPrice.setStudentWeekday(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 3:
					System.out.println("Enter new Student Weekday 3D price");
					ticketPrice.setStudentWeekday3D(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 4:
					System.out.println("Enter new Mon-Wed price");
					ticketPrice.setMonWed(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 5:
					System.out.println("Enter new Mon-Wed 3D price");
					ticketPrice.setMonWed3D(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 6:
					System.out.println("Enter new Thu price");
					ticketPrice.setThu(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 7:
					System.out.println("Enter new Thu3D price");
					ticketPrice.setThu3D(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 8:
					System.out.println("Enter new Fri Afternoon price");
					ticketPrice.setFriAft(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 9:
					System.out.println("Enter new Fri Afternoon 3D price");
					ticketPrice.setFriAft3D(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 10:
					System.out.println("Enter new Fri Evening price");
					ticketPrice.setFriEve(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 11:
					System.out.println("Enter new Fri Evening 3D price");
					ticketPrice.setFriEve3D(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 12:
					System.out.println("Enter new Weekend price");
					ticketPrice.setWeekend(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 13:
					System.out.println("Enter new Weekend 3D price");
					ticketPrice.setWeekend3D(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
				case 14:
					System.out.println("Enter new Preferred credit/loyalty card price");
					ticketPrice.setCard(ScannerController.getInputDouble());
					ticketPriceController.overwritePricesList(ticketPrice);
					continue;
			}
		}
	}
}
