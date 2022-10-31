package ExceptionPackage;

public class CinemaCodeNameException extends CodeNameException {
	public CinemaCodeNameException(){
		super("Cinema code must be at least 5 characters");
	}
}
