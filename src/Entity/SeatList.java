package Entity;

import ExceptionPackage.SeatDoesNotExistException;
import ExceptionPackage.SeatOccupiedException;

import java.io.Serializable;

/**
 * This SeatList class represents the whole Cinema's seats as seatingPlan.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-03
 */
public class SeatList implements Serializable {
	private Seat[][] seatingPlan;
	public SeatList(){
		seatingPlan = new Seat[9][18];
		initialiseSeats();
	}

	/**
	 * Initialise seats according to Appendix A seating diagram
	 */
	private void initialiseSeats(){
		for(int row = 0; row<= 8; row++){
			for(int col = 0; col<= 17; col++){
				seatingPlan[row][col] = new Seat();
				if((col<2 && row>4)) {
					seatingPlan[row][col].setExists(false); //Empty seating block in upper left
				}
				if(row==0 && (col==8 || col==9)){
					seatingPlan[row][col].setExists(false); //Empty seating block in bottom middle
				}
				if(row<3 && !(row == 0 && (col == 10 || col==11))){
					seatingPlan[row][col].setCoupleSeat();  //Set couple seats in rows 1-3 excl. a small spot
				}
			}
		}
	}

	public Seat[][] getSeatingPlan() {
		return seatingPlan;
	}

	public void setSeatingPlan(Seat[][] seatingPlan) {
		this.seatingPlan = seatingPlan;
	}

	public SeatList bookSeat(char rowChar, int col) throws SeatDoesNotExistException, SeatOccupiedException {
		Seat[][] tempSeatArray = this.getSeatingPlan();
		int row;
		switch (rowChar) {
			case 'A':
				row = 1;
				break;
			case 'B':
				row = 2;
				break;
			case 'C':
				row = 3;
				break;
			case 'D':
				row = 4;
				break;
			case 'E':
				row = 5;
				break;
			case 'F':
				row = 6;
				break;
			case 'G':
				row = 7;
				break;
			case 'H':
				row = 8;
				break;
			case 'I':
				row = 9;
				break;
			default:
				row = -1;
				break;
		}
		if (row == -1 || col < 1 || col > 18 || !tempSeatArray[row - 1][col - 1].isExists()) {
			throw new SeatDoesNotExistException();
		}
		if (tempSeatArray[row - 1][col - 1].isOccupied()) {
			throw new SeatOccupiedException();
		}
		tempSeatArray[row - 1][col - 1].assignSeat();            //book the seat

		if (tempSeatArray[row - 1][col - 1].isCoupleSeat()) {    //if booking a couple seat, book the other seat also
			if (row % 2 == 0) {
				tempSeatArray[row - 1][col - 2].assignSeat();
			} else {
				tempSeatArray[row - 1][col].assignSeat();
			}
		}

		SeatList returnedList = new SeatList();
		returnedList.setSeatingPlan(tempSeatArray);
		return returnedList;
	}
}
