package Entity;

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
}
