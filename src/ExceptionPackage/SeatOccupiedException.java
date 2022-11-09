package ExceptionPackage;
/**
 * Custom SeatOccupiedException thrown when booking an occupied seat.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class SeatOccupiedException extends Exception {
	public SeatOccupiedException(){
		super("Seat is already occupied");
	}
}
