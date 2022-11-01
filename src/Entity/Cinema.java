package Entity;

import ExceptionPackage.CinemaCodeNameException;
import ExceptionPackage.InvalidCinemaSeatException;

/**
 * This Cinema class contains data about itself. Different (non-normal) types of Cinema are extensions of this class.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-10-31
 */
public class Cinema {
	enum CinemaTypes {
		CIN_NORMAL,
		CIN_3D,
		CIN_PREMIUM,
	}
	String name;
	String nameCode;
	CinemaTypes cinemaType;
	int[][] seats;

	/**
	 * Constructor for a Cinema.
	 * @param name Name of the cinema.
	 * @param nameCode Codename of the cinema.
	 * @param cinemaType Enum type of cinema.
	 * @param seats The seats in the cinema.
	 * @throws CinemaCodeNameException nameCode is checked to be 5 characters long.
	 * @throws InvalidCinemaSeatException seats is checked to be at least 1 row and 1 column.
	 */
	public Cinema(String name, String nameCode, CinemaTypes cinemaType, int[][] seats) throws CinemaCodeNameException, InvalidCinemaSeatException{
		this.name = name;
		if(nameCode.length()<10){
			throw new CinemaCodeNameException();
		} else {
			this.nameCode = nameCode;
		}

		this.cinemaType = cinemaType;

		if(seats.length <1 || seats[0].length<1){
			throw new InvalidCinemaSeatException();
		}

	}

	/**
	 * Overloaded constructor similar to {@link Cinema#Cinema(String, String, CinemaTypes, int[][])}.
	 * Omitting CinemaTypes parameter, the default value of cinemaType is set to CIN_NORMAL.
	 * @see Cinema#Cinema(String, String, CinemaTypes, int[][])
	 */
	public Cinema(String name, String nameCode, int[][] seats) throws CinemaCodeNameException, InvalidCinemaSeatException{
		this.name = name;
		if(nameCode.length()<10){
			throw new CinemaCodeNameException();
		} else {
			this.nameCode = nameCode;
		}
		this.cinemaType = CinemaTypes.CIN_NORMAL;

		if(seats.length <1 || seats[0].length<1){
			throw new InvalidCinemaSeatException();
		} else {
			this.seats = seats;
		}
	}

	/**
	 * Get the name of the cinema.
	 * @return Name of cinema.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the cinema.
	 * @param name Name of cinema.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the codename of the cinema.
	 * @return Codename of the cinema.
	 */
	public String getNameCode() {
		return nameCode;
	}

	/**
	 * Set the codename of the cinema.
	 * @param nameCode Codename of the cinema.
	 * @throws CinemaCodeNameException nameCode is checked to be 5 characters long.
	 */
	public void setNameCode(String nameCode) throws CinemaCodeNameException{
		if(nameCode.length()<10){
			throw new CinemaCodeNameException();
		} else {
			this.nameCode = nameCode;
		}
	}

	/**
	 * Get the type of cinema.
	 * @return CinemaType of cinema.
	 */
	public CinemaTypes getCinemaType() {
		return cinemaType;
	}

	/**
	 * Set the type of cinema.
	 * @param cinemaType CinemaType of cinema.
	 */
	public void setCinemaType(CinemaTypes cinemaType) {
		this.cinemaType = cinemaType;
	}

	/**
	 * Get the seats in the cinema.
	 * @return Seats in the cinema.
	 */
	public int[][] getSeats() {
		return seats;
	}

	/**
	 * Set the seats in the cinema.
	 * @param seats Seats in the cinema.
	 * @throws InvalidCinemaSeatException seats is checked to be at least 1 row and 1 column.
	 */
	public void setSeats(int[][] seats) throws InvalidCinemaSeatException{
		if(seats.length <1 || seats[0].length<1){
			throw new InvalidCinemaSeatException();
		} else {
			this.seats = seats;
		}
	}
}
