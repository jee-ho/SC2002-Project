package ExceptionPackage;
/**
 * Custom ExistingMovieException thrown when attempting to add a movie with same name.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-05
 */
public class ExistingMovieException extends Exception {
	public ExistingMovieException() {
		super("Movie with this title already exists");
	}
}
