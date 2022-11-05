package ExceptionPackage;

public class NoSuchCinemaException extends Exception {
	public NoSuchCinemaException(){
		super("No cinema by this name found");
	}
}
