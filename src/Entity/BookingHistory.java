package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BookingHistory implements Serializable {
    private String tID;
    private MovieGoer movieGoer;
    private String name;
    private String screen;
    private Movie movie;
    private LocalDateTime showTime;
    private LocalDateTime time;
    private String ticketType;
    private char seatRow;
    private int seatCol;
    private double price;
    //public static List<BookingHistory> bookingHistoryList = new ArrayList<BookingHistory>();

    public BookingHistory(String tID, MovieGoer movieGoer, String name, String screen, Movie movie, LocalDateTime showTime, LocalDateTime time, String ticketType, char seatRow, int seatCol, double price){
		this.tID = tID;
        this.movieGoer = movieGoer;
        this.name = name;
        this.screen = screen;
        this.movie = movie;
        this.showTime = showTime;
        this.time = time;
        this.ticketType = ticketType;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.price = price;
	}

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public MovieGoer getmovieGoer() {
        return movieGoer;
    }

    public void setmovieGoer(MovieGoer movieGoer) {
        this.movieGoer = movieGoer;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getscreen() {
        return screen;
    }

    public void setscreen(String screen) {
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    // public String getscreen() {
    //     return screen;
    // }

    // public void setscreen(String screen) {
    //     this.screen = screen;
    // }

    // public String getmovieTitle() {
    //     return movieTitle;
    // }

    // public void setmovieTitle(String movieTitle) {
    //     this.movieTitle = movieTitle;
    // }

    // public String getmoviemovieRating() {
    //     return movieRating;
    // }

    // public void setmovieRating(String movieRating) {
    //     this.movieRating = movieRating;
    // }

    public LocalDateTime getshowTime() {
        return showTime;
    }

    public void setshowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public LocalDateTime gettime() {
        return time;
    }

    public void settime(LocalDateTime time) {
        this.time = time;
    }

    public String getticketType() {
        return ticketType;
    }

    public void setticketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public char getseatRow() {
        return seatRow;
    }

    public void setseatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public int getseatCol() {
        return seatCol;
    }

    public void setseatCol(int seatCol) {
        this.seatCol = seatCol;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }
}
