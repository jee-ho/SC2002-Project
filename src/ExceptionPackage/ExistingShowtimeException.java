package ExceptionPackage;

public class ExistingShowtimeException extends Exception {
	public ExistingShowtimeException(){
		super("Show time already exists");
	}
}
