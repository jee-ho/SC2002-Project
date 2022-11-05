package ExceptionPackage;

public class ExistingMovieException extends Exception {
	public ExistingMovieException() {
		super("Movie with this title already exists");
	}
}
