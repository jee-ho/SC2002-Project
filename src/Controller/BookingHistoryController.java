package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import Entity.BookingHistory;
import Entity.Movie;
import Entity.MovieGoer;

public class BookingHistoryController {
    public final static String FILENAME = "bookingHistory.txt";

    public void addBookingHistory(String tID, MovieGoer movieGoer, String name, String screen, Movie movie, LocalDateTime showTime, LocalDateTime time, String ticketType, char seatRow, int seatCol, double price) {
        try {
            FileOutputStream file = new FileOutputStream(FILENAME);
            ObjectOutputStream outputStream = new ObjectOutputStream(file);
            ArrayList<BookingHistory> bookingHistoryList = new ArrayList<BookingHistory>();
            BookingHistory bookingHistory = new BookingHistory(tID, movieGoer, name, screen, movie, showTime, time, ticketType, seatRow, seatCol, price);
            bookingHistoryList.add(bookingHistory);
            outputStream.writeObject(bookingHistoryList);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void viewUserBookingHistory(MovieGoer currentUser) {
		try {
            ArrayList<BookingHistory> userHistoryList = new ArrayList<BookingHistory>();
            ArrayList<BookingHistory> bookingHistoryList = viewAllBookingHistory();
            int i = 1;
            DateTimeFormatter transFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
            DateTimeFormatter dateFormatObj = DateTimeFormatter.ofPattern("EEE, dd-MM-yyyy");
            DateTimeFormatter timeFormatObj = DateTimeFormatter.ofPattern("HH:mm a");
			// objStream.close();
            for (BookingHistory bHistory : bookingHistoryList){
                // System.out.print(bHistory.getmovieGoer().getUsername());
                String user = bHistory.getmovieGoer().getUsername();
                String username = currentUser.getUsername();
                System.out.println(currentUser.equals(((MovieGoer)bHistory.getmovieGoer())));
                System.out.println(currentUser.equals(bHistory.getmovieGoer()));
                // if (user.equals(username)) {
                userHistoryList.add(bHistory);
                // }
            }
            if (userHistoryList.isEmpty()) {
                System.out.println("You have no booking history. Why not check out our list of movies?");
            }
            else {
                for (BookingHistory bookhist : userHistoryList) {
                    String movieStatus = bookhist.getMovie().getStatus().toString();
                    if (movieStatus.equals("nowshowing")) {
                        System.out.println("    =====================================================");
                        System.out.println("                       Booking History");
                        System.out.println("    =====================================================");
                        System.out.println("    "+i+".  Ticket ID: "+bookhist.gettID());
                        System.out.println("        Transaction Date: "+bookhist.gettime().format(transFormatObj));
                        System.out.println("        Cinema: "+bookhist.getname()+" - " + bookhist.getscreen().toUpperCase());
                        System.out.println("        Movie: "+bookhist.getMovie().getTitle()+" "+bookhist.getMovie().getType());
                        System.out.println("        Date: "+bookhist.getshowTime().format(dateFormatObj));
                        System.out.println("        Time: "+bookhist.getshowTime().format(timeFormatObj));
                        System.out.println("        Ticket(s): "+bookhist.getticketType()+" ("+bookhist.getseatRow()+bookhist.getseatCol()+")");
                        System.out.println("        Total Payment: $"+String.format("%.2f",bookhist.getprice()));
                        i++;
                    }
                    else if (movieStatus.equals("endofshowing")) {
                        System.out.println("    =====================================================");
                        System.out.println("                     Transaction History");
                        System.out.println("    =====================================================");
                    }
                }
                System.out.println("    =====================================================");
                System.out.println("                            End");
                System.out.println("    =====================================================");
            }
            
            
            // return bookingHistoryList;	
            
		} catch (Exception e) {
			// return new ArrayList<BookingHistory>();
		}
	}
    
    public ArrayList<BookingHistory> viewAllBookingHistory() {
        try {
            FileInputStream fileStream = new FileInputStream(FILENAME);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);
			ArrayList<BookingHistory> bookingHistoryList = (ArrayList<BookingHistory>) objStream.readObject();
			objStream.close();
            return bookingHistoryList;	
            
		} catch (IOException | ClassNotFoundException e) {
            return new ArrayList<BookingHistory>();
		} 
    }
    
    public void getAllBookingHistory() {
        ArrayList<BookingHistory> bookingHistoryList = viewAllBookingHistory();
        int i = 1;
        for(BookingHistory bookingHistory : bookingHistoryList){
            System.out.println(i + ": " + bookingHistory.getmovieGoer().getFullName() + " (" +bookingHistory.getticketType() + ")");
            i++;
        }
    }
    // public ArrayList<BookingHistory> read() {
    //     try {
	// 		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME));
	// 		ArrayList<BookingHistory> MovieList = (ArrayList<BookingHistory>) inputStream.readObject();
	// 		inputStream.close();
	// 		return MovieList;
	// 	} catch (IOException | ClassNotFoundException e) {
	// 		return new ArrayList<BookingHistory>();
	// 	}
    // }

    // public void getMovieCatalog(){
	// 	ArrayList<BookingHistory> tempMovieList = read();
	// 	int i = 1;
	// 	for(BookingHistory mov : tempMovieList){
	// 		// if(mov() != Movie.ShowStatus.ENDOFSHOWING){
	// 		System.out.println(i + ": " + mov.gettID() + " (" + mov.getseatCol() + ")");
	// 		// }
	// 		i++;
	// 	}
	// }

}
