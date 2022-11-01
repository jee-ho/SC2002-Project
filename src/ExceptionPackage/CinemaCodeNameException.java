package ExceptionPackage;

public class CinemaCodeNameException extends Exception {
	public CinemaCodeNameException(){
		super("Cinema code must be at least 10 characters");
	}
}
