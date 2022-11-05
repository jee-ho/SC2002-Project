package Entity;

import ExceptionPackage.CinemaCodeNameException;

/**
 * This CinemaPlatinumSuite class is a specialised Cinema object representing a Platinum Suite cinema.
 */
public class CinemaPlatinumSuite extends Cinema {
	/**
	 * Specific constructor for a Platinum Suite Cinema, declaring its CinemaType as CIN_PREMIUM.
	 * Calls parent constructor {@link Cinema#Cinema(String, String, CinemaTypes)}.
	 * @see Cinema#Cinema(String, String, CinemaTypes)
	 */
	public CinemaPlatinumSuite(String name, String nameCode) throws CinemaCodeNameException {
		super(name, nameCode, CinemaTypes.CIN_PREMIUM);
	}
}
