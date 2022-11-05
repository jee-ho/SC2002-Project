package ExceptionPackage;

public class NoSuchMovieException extends Exception {
	public NoSuchMovieException(){
		super("Movie by this name was not found");
	}
}
