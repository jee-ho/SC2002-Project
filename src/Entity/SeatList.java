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


	public void printLayout(){
		for(int row = 9; row>= 0; row--){
			for(int col = 0; col<= 18; col++){
				if(col==9)
					System.out.print("  ");			//Make a space for the middle aisle
				if(row == 0){
					if(col<10 && col!=0){
						System.out.print(" ");		//Align single-digit cols preceded by space to match double-digit
					}
					System.out.print(col + " ");	//Print col number with a space after
				}
				if(col == 0&&row!=0){
					System.out.print(row + " ");	//Print row number with a space after
				}
				if(row>0 && col>0){
					if(seatingPlan[row-1][col-1].isExists() && seatingPlan[row-1][col-1].isCoupleSeat()){
						System.out.print(" C ");	//Mark couple seats
					} else if(seatingPlan[row-1][col-1].isExists()){
						System.out.print(" O ");	//Mark existing seats
					} else if(!seatingPlan[row-1][col-1].isExists()){
						System.out.print("   ");	//Show empty space for non-existent seats
					}
					//TODO: Marking of occupied seats and occupied couple seats

				}
			}
			System.out.println();	//Newline every row
		}


	}
}
