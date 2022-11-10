package Boundary;

import Controller.BookingHistoryController;
import Controller.ScannerController;
import Entity.MovieGoer;

public class BookingHistoryApp {
    BookingHistoryController bookingHistoryController = new BookingHistoryController();

    public void main(MovieGoer currentUser) {
        int choice = 0;
        bookingHistoryController.viewUserBookingHistory(currentUser);
        System.out.println("These are your booking history. 0 to exit.");
        choice = ScannerController.getInputInt();
        choice--;
        if(choice == -1) {
            return;
        }
    }
    
}
