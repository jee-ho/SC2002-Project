package ExceptionPackage;
/**
 * Custom NoSuchCinemaException thrown when finding a cinema name that doesn't exist.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class NoSuchCinemaException extends Exception {
	public NoSuchCinemaException(){
		super("No cinema by this name found");
	}
}
