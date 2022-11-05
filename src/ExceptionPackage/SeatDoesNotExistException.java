package ExceptionPackage;

public class SeatDoesNotExistException extends Exception {
	public SeatDoesNotExistException(){
		super("Seat row/col out of range or does not exist");
	}
}
