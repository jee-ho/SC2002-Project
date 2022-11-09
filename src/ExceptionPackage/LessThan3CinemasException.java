package ExceptionPackage;
/**
 * Custom LessThan3CinemasException thrown when cineplex contains less than 3 cinemas.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-10-31
 */
public class LessThan3CinemasException extends Exception {
	public LessThan3CinemasException(){
		super("A cineplex cannot have less than 3 cinemas");
	}
}
