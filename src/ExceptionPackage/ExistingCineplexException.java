package ExceptionPackage;

public class ExistingCineplexException extends Exception {
	public ExistingCineplexException(){
		super("Cineplex with this name already exists");
	}
}
