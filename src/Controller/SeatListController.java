package Controller;

import Entity.Seat;

import Entity.SeatList;
/**
 * Controller for interfacing with SeatList objects.
 * @author Tan Chuan Liang
 * @version 1.0
 * @since 2022-11-08
 */

public class SeatListController {
	/**
	 * Print the layout of a seating plan.
	 * @param seatingPlan Seating plan to print.
	 */
	public void printLayout(SeatList seatingPlan){
		Seat[][] tempSeatArray = seatingPlan.getSeatingPlan();
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
					char rowChar = 'A';
					switch(row){
						case 1: rowChar = 'A'; break;
						case 2: rowChar = 'B'; break;
						case 3: rowChar = 'C'; break;
						case 4: rowChar = 'D'; break;
						case 5: rowChar = 'E'; break;
						case 6: rowChar = 'F'; break;
						case 7: rowChar = 'G'; break;
						case 8: rowChar = 'H'; break;
						case 9: rowChar = 'I'; break;
						default: rowChar = 'Z'; break;
					}
					System.out.print(rowChar + " ");	//Print row number with a space after
				}
				if(row>0 && col>0){
					if(tempSeatArray[row-1][col-1].isExists() && tempSeatArray[row-1][col-1].isOccupied()){
						System.out.print(" X ");
					} else if(tempSeatArray[row-1][col-1].isExists() && tempSeatArray[row-1][col-1].isCoupleSeat()){
						System.out.print(" C ");	//Mark couple seats
					} else if(tempSeatArray[row-1][col-1].isExists()){
						System.out.print(" O ");	//Mark existing seats
					} else if(!tempSeatArray[row-1][col-1].isExists()){
						System.out.print("   ");	//Show empty space for non-existent seats
					}
				}
			}
			System.out.println();	//Newline every row
		}
	}

}
