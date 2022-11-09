package ExceptionPackage;
/**
 * Custom CinemaCodeNameException thrown when cinema name is too short (less than 10 characters).
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-10-31
 */
public class CinemaCodeNameException extends Exception {
	public CinemaCodeNameException(){
		super("Cinema code must be at least 10 characters");
	}
}
