package Entity;

import java.io.Serializable;

/**
 * This Seat class represents a single seat. It has 3 boolean flags for whether it exists, is occupied, or is part of a couple seat.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-03
 */
public class Seat implements Serializable {
	private boolean isExists = true;
	private boolean isOccupied = false;
	private boolean isCoupleSeat = false;

	/**
	 * Check if this seat exists
	 * @return True if seat exists
	 */
	public boolean isExists() {
		return isExists;
	}

	/**
	 * Set existence of this seat
	 * @param exists Boolean value of whether the seat exists
	 */
	public void setExists(boolean exists) {
		isExists = exists;
	}

	/**
	 * Check if this seat is occupied
	 * @return True if seat is occupied
	 */
	public boolean isOccupied() {
		return isOccupied;
	}

	/**
	 * Assign the seat to be occupied.
	 */
	public void assignSeat() {
		isOccupied = true;
	}

	/**
	 * Unassign seat to be unoccupied.
	 */
	public void unAssignSeat() {
		isOccupied = false;
	}

	/**
	 * Check if seat is a couple seat.
	 * @return Boolean value of whether the seat is a couple seat
	 */
	public boolean isCoupleSeat() {
		return isCoupleSeat;
	}

	/**
	 * Set this seat to be a couple seat
	 */
	public void setCoupleSeat() {
		isCoupleSeat = true;
	}
}
