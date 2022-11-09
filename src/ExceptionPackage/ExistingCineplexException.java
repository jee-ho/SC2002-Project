package ExceptionPackage;
/**
 * Custom ExistingCineplexException thrown when attempting to add a cineplex with same name.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-03
 */
public class ExistingCineplexException extends Exception {
	public ExistingCineplexException(){
		super("Cineplex with this name already exists");
	}
}
