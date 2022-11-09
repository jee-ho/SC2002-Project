package ExceptionPackage;
/**
 * Custom ExistingUserException thrown when adding User when that username is already taken.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */
public class ExistingUserException extends Exception {
		public ExistingUserException(){
			super("User with this username already exists");
		}
}
