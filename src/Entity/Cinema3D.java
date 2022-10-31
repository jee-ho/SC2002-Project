package Entity;

import ExceptionPackage.CinemaCodeNameException;
import ExceptionPackage.InvalidCinemaSeatException;

/**
 * This Cinema3D class is a specialised Cinema object representing a 3D movie cinema.
 */
public class Cinema3D extends Cinema {
	/**
	 * Specific constructor for a 3D Cinema, declaring its CinemaType as CIN_3D .
	 * Calls parent constructor {@link Cinema#Cinema(String, String, CinemaTypes, int[][])}.
	 * @see Cinema#Cinema(String, String, CinemaTypes, int[][])
	 */
	public Cinema3D(String name, String nameCode, int[][] seats) throws InvalidCinemaSeatException, CinemaCodeNameException {
		super(name, nameCode, CinemaTypes.CIN_3D, seats);
	}
}
