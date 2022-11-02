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

	public boolean isExists() {
		return isExists;
	}

	public void setExists(boolean exists) {
		isExists = exists;
	}

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

	public boolean isCoupleSeat() {
		return isCoupleSeat;
	}

	public void setCoupleSeat() {
		isCoupleSeat = true;
	}
}
