package ExceptionPackage;

public class ExistingUserException extends Exception {
		public ExistingUserException(){
			super("User with this username already exists");
		}
}
