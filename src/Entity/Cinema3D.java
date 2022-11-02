package Entity;

import ExceptionPackage.CinemaCodeNameException;

/**
 * This Cinema3D class is a specialised Cinema object representing a 3D movie cinema.
 */
public class Cinema3D extends Cinema {
	/**
	 * Specific constructor for a 3D Cinema, declaring its CinemaType as CIN_3D .
	 * Calls parent constructor {@link Cinema#Cinema(String, String, CinemaTypes, SeatList)}.
	 * @see Cinema#Cinema(String, String, CinemaTypes, SeatList)
	 */
	public Cinema3D(String name, String nameCode, SeatList seats) throws CinemaCodeNameException {
		super(name, nameCode, CinemaTypes.CIN_3D, seats);
	}
}
