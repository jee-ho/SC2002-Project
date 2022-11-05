package ExceptionPackage;

public class SeatOccupiedException extends Exception {
	public SeatOccupiedException(){
		super("Seat is already occupied");
	}
}
