package ExceptionPackage;

public class InvalidCinemaSeatException extends Exception {
	public InvalidCinemaSeatException(){
		super("A cinema's seats must have at least 1 row and 1 column");
	}
}
