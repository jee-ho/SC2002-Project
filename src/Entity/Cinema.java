package Entity;

import ExceptionPackage.CinemaCodeNameException;

import java.io.Serializable;

/**
 * This Cinema class contains data about itself. Different (non-normal) types of Cinema are extensions of this class.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-10-31
 */
public class Cinema implements Serializable {
	public enum CinemaTypes {
		CIN_NORMAL,
		CIN_3D,
		CIN_PREMIUM,
	}
	private String name;
	private String nameCode;
	private CinemaTypes cinemaType;
	private SeatList seats;			//TODO move seats to be a field of ShowTime

	/**
	 * Constructor for a Cinema.
	 * @param name Name of the cinema.
	 * @param nameCode Codename of the cinema.
	 * @param cinemaType Enum type of cinema.
	 * @param seats The seats in the cinema.
	 * @throws CinemaCodeNameException nameCode is checked to be 5 characters long.
	 */
	public Cinema(String name, String nameCode, CinemaTypes cinemaType, SeatList seats) throws CinemaCodeNameException{
		this.name = name;
		if(nameCode.length()<10){
			throw new CinemaCodeNameException();
		} else {
			this.nameCode = nameCode;
		}

		this.cinemaType = cinemaType;

		this.seats = seats;

	}

	/**
	 * Overloaded constructor similar to {@link Cinema#Cinema(String, String, CinemaTypes, SeatList)}.
	 * Omitting CinemaTypes parameter, the default value of cinemaType is set to CIN_NORMAL.
	 * @see Cinema#Cinema(String, String, CinemaTypes, SeatList)
	 */
	public Cinema(String name, String nameCode, SeatList seats) throws CinemaCodeNameException{
		this.name = name;
		if(nameCode.length()<10){
			throw new CinemaCodeNameException();
		} else {
			this.nameCode = nameCode;
		}
		this.cinemaType = CinemaTypes.CIN_NORMAL;

		this.seats = seats;

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
	public SeatList getSeats() {
		return seats;
	}

	/**
	 * Set the seats in the cinema.
	 * @param seats Seats in the cinema.
	 */
	public void setSeats(SeatList seats){
		this.seats = seats;
	}
}
