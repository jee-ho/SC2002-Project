package ExceptionPackage;
/**
 * Custom ExistingShowtimeException thrown when attempting to add a ShowTime with same signature.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class ExistingShowtimeException extends Exception {
	public ExistingShowtimeException(){
		super("Show time already exists");
	}
}
