package ExceptionPackage;

public class LessThan3CinemasException extends Exception {
	public LessThan3CinemasException(){
		super("A cineplex cannot have less than 3 cinemas");
	}
}
