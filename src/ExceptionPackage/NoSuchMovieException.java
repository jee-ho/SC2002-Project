package ExceptionPackage;
/**
 * Custom NoSuchMovieException thrown when finding a movie name that doesn't exist.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class NoSuchMovieException extends Exception {
	public NoSuchMovieException(){
		super("Movie by this name was not found");
	}
}
