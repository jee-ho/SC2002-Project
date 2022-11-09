package ExceptionPackage;
/**
 * Custom SeatDoesNotExistException thrown when finding a seat that doesn't exist.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class SeatDoesNotExistException extends Exception {
	public SeatDoesNotExistException(){
		super("Seat row/col out of range or does not exist");
	}
}
