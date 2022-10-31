package Entity;

import ExceptionPackage.CinemaCodeNameException;
import ExceptionPackage.InvalidCinemaSeatException;

/**
 * This CinemaPlatinumSuite class is a specialised Cinema object representing a Platinum Suite cinema.
 */
public class CinemaPlatinumSuite extends Cinema {
	/**
	 * Specific constructor for a Platinum Suite Cinema, declaring its CinemaType as CIN_PREMIUM.
	 * Calls parent constructor {@link Cinema#Cinema(String, String, CinemaTypes, int[][])}.
	 * @see Cinema#Cinema(String, String, CinemaTypes, int[][])
	 */
	public CinemaPlatinumSuite(String name, String nameCode, int[][] seats) throws InvalidCinemaSeatException, CinemaCodeNameException {
		super(name, nameCode, CinemaTypes.CIN_PREMIUM, seats);
	}
}
