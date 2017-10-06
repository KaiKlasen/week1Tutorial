import java.util.Scanner;

/**
* <dl>
* <dt> Purpose:
* <dd> Game of chess
*
* <dt> Description:
* <dd> This program is a virtual chess game for two players
* </dl>
* @author Kai Klasen
* @version Date: 30/09/2017
*/

public class Exercise5_VirtualChessboard {

	public enum Chessmen {
		WHITE_KING,
		WHITE_QUEEN,
		WHITE_ROOK,
		WHITE_BISHOP,
		WHITE_KNIGHT,
		WHITE_PAWN,
		BLACK_KING,
		BLACK_QUEEN,
		BLACK_ROOK,
		BLACK_BISHOP,
		BLACK_KNIGHT,
		BLACK_PAWN,
		EMPTY
	}
	
	/**
	* <dl>
	* <dt> Purpose:
	* <dd> Main method
	*
	* <dt> Description:
	* <dd> creates board, fills it, prints it, takes user input for moves and checks if they are valid
	* </dl>
	*/
	
	public static void main(String[] args) {
		
		System.err.println("Welcome to the game of chess! Here are the rules: white (the bottom) starts. You do an incorrect move  ");
		
		//create a chess board of size 8x8 
		Chessmen [][] chessboard = new Chessmen[8][8];
	
		//initial filling of chess board with figures
		fillBoard(chessboard);
		
		//prints initial board configuration to console
		printBoard(chessboard);
		
		boolean end = false;
		String move = "exit";
		int turnCount = 1;
		
		System.out.println("\nEnter move in notation: 'e1 to e5' else type 'exit' to leave");
		
		//looping game play by users: input, checking input, move() incl validation and print board
		do{		
			//user input through scanner
			Scanner scan = new Scanner(System.in);
			move = scan.nextLine().toLowerCase();
			
			//convert move into array positions
			String[] components = move.split(" ");
			int oldI = Math.abs(8-(components[0].charAt(1) % 48)); 
			int oldJ = Math.abs(8-(components[0].charAt(0) % 96));
			
			//players want to exit game
			if(move.compareTo("exit") == 0 ){
				end = true;
			}
			//faulty move entry
			else if(move.length() != 8){
				System.err.println("Error: move not per specifications! Try again");
				continue;
			}
			//other player's turn (checking for odd number)
			else if(turnCount % 2 == 1){
				if(!chessboard[oldI][oldJ].toString().startsWith("W")){
					System.err.println("Error - white it's your turn!");
					continue;
				}
				move(chessboard, move);
				printBoard(chessboard);
				turnCount++;
				continue;
			}
			else if (turnCount % 2 == 0){
				if(!chessboard[oldI][oldJ].toString().startsWith("B")){
					System.err.println("Error - black it's your turn!");
					continue;
				}
				move(chessboard, move);
				printBoard(chessboard);
				turnCount++;
				continue;
			}  
			else{
				move(chessboard, move);
				printBoard(chessboard);
				turnCount++;
			}
		}while(end == false);
		
		
		//Print Goodbye message
		System.out.println("Thank you for playing this awesome game of chess!\n");
	}
	
	public static Chessmen[][] fillBoard(Chessmen [][] chessboard){
	
		//fill the board with the pieces and empty space
				for(int i = 0 , length = chessboard.length ; i < length; i++){
					
					for(int j = 0, width = chessboard[0].length ; j < width; j++){

						//dark pawn
						if(i == 1){
							chessboard[i][j] = Chessmen.BLACK_PAWN;
						}
						//white pawn
						if(i == 6){
							chessboard[i][j] = Chessmen.WHITE_PAWN;
						}
						//white space
						if(i > 1 && i < 6){
							chessboard[i][j] = Chessmen.EMPTY;
						}
						
						//dark queen
						if(i == 0 && j == 3){
							chessboard[i][j] = Chessmen.BLACK_QUEEN;
						}
						//white queen
						if(i == 7 && j == 3){
							chessboard[i][j] = Chessmen.WHITE_QUEEN;
						}
						//dark king
						if(i == 0 && j == 4){
							chessboard[i][j] = Chessmen.BLACK_KING;
						}
						//white king
						if(i == 7 && j == 4){
							chessboard[i][j] = Chessmen.WHITE_KING;
						}
						
						//dark rooks
						if(i == 0 && (j == 0 || j == 7) ){
							chessboard[i][j] = Chessmen.BLACK_ROOK;
						}
						//white rooks
						if(i == 7 && (j == 0 || j == 7) ){
							chessboard[i][j] = Chessmen.WHITE_ROOK;
						}
						//dark knights
						if(i == 0 && (j == 1 || j == 6)){
							chessboard[i][j] = Chessmen.BLACK_KNIGHT;
						}
						//white knights
						if(i == 7 && (j == 1 || j == 6)){
							chessboard[i][j] = Chessmen.WHITE_KNIGHT;
						}
						//dark bishops
						if(i == 0 && (j == 2 || j == 5)) {
							chessboard[i][j] = Chessmen.BLACK_BISHOP;
						}
						//white bishops
						if(i == 7 && (j == 2 || j == 5)) {
							chessboard[i][j] = Chessmen.WHITE_BISHOP;
						}
					}
				}
		return chessboard; 
	}
		
	public static void printBoard(Chessmen [][] chessboard){
		
		//labels for the sides of the board to be printed 
		int numcount = chessboard.length;
		char charcount = 97;
		
		//loop to print the chess board including additional row and column for labeling into the console
		for(int i = 0, length = chessboard.length +1 ; i < length ; i++){
	
			//prints the first row of the 9x9 matrix which contains only the descriptions a-h
			if (i == 0){
				System.out.print(" \t");
				for(int k = 1; k < length; k++){
					System.out.print(charcount+"\t");
					charcount++;
				}
				System.out.println("\n");
			} 
			else{
				for(int j = 0, width = chessboard[0].length +1 ; j < width ; j++){
				
					if (j == 0){
						System.out.print(numcount+".\t");
						numcount--;
					}
					else{
						switch (chessboard[i-1][j-1]){
						case BLACK_PAWN: System.out.print("\u2659\t");
							break;
						case WHITE_PAWN: System.out.print("\u265F\t");
							break;
						case BLACK_QUEEN: System.out.print("\u2655\t");
							break;
						case WHITE_QUEEN: System.out.print("\u265B\t");
							break;
						case BLACK_KING: System.out.print("\u2654\t");
							break;
						case WHITE_KING: System.out.print("\u265A\t");
							break;
						case BLACK_ROOK: System.out.print("\u2656\t");
							break;
						case WHITE_ROOK: System.out.print("\u265C\t");
							break;
						case BLACK_KNIGHT: System.out.print("\u2658\t");
							break;
						case WHITE_KNIGHT: System.out.print("\u265E\t");
							break;
						case BLACK_BISHOP: System.out.print("\u2657\t");
							break;
						case WHITE_BISHOP: System.out.print("\u265D\t");
							break;
						case EMPTY: System.out.print("  \t");
							break;
						default: System.out.print("error"); 
						}
					}
						
				}
			System.out.println();
			}
		}
	}
	
	public static void move(Chessmen[][] chessboard, String move){

		//parsing string:"move" into components e.g. "e1 to e3" = {e1, e3}
		String[] components = move.split(" ");
		
		//old location on chess board
		int oldI = components[0].charAt(1) % 48; 
		int oldJ = components[0].charAt(0) % 97;
		
		//new location on chess board
		int newI = components[2].charAt(1) % 48; 
		int newJ = components[2].charAt(0) % 97;
		
		if(isValid(chessboard, oldI, oldJ, newI, newJ ) == true ){
			
			//inverts the user's commands so move direction is correct
			oldI = Math.abs(oldI-8);
			newI = Math.abs(newI-8);
	
			//move current chess piece ( @chessboard[old][old] ) to new location
			chessboard[newI][newJ] = chessboard[oldI][oldJ];
			
			//store empty field in old location
			chessboard[oldI][oldJ] = Chessmen.EMPTY;
		}
		else{
			System.err.print("Please try again!");
		}	
	}
	
	public static Boolean isValid(Chessmen[][] chessboard, int oldI, int oldJ, int newI, int newJ) {
			
		//1. check if move to new position is still in field
		if( !((0 <= newI && newI <= 8) && (0 <= newJ && newJ <= 8)) ){
			System.err.print("Error: out of chessboard");
			return false; 
		}
		
		//convert player input "1-8" to array "0-7" 
		oldI = Math.abs(oldI-8);
		newI = Math.abs(newI-8);
		
		//2. check if target field is not empty & if so if target is populated with same colour
		if(chessboard[newI][newJ] != Chessmen.EMPTY){
			//converts Chessmen type input into string and allows to compare first letter of both fields
			if(chessboard[newI][newJ].toString().charAt(0) == chessboard[oldI][oldJ].toString().charAt(0)){  
				System.err.print("Error: friendly fire! Your buddy sits there -> Can't move there. ");
				return false;
			}
		}
		//3. switch statement to check for each figure specifically which moves are legal and which ones aren't
		switch (chessboard[oldI][oldJ]) {
			case WHITE_PAWN: 

				//a. checking sideways move 
				if( (newI == oldI -1 && newJ == oldJ +1) || (newI == oldI -1 && newJ == oldJ -1) ){
					if(chessboard[newI][newJ].toString().startsWith("B")){
						return true;
					}else{
						System.err.print("Error: PAWN can only move diagonally to kill an enemy");
						return false;
					}
				}
				//b. checking two steps upon initial move
				else if(newI == oldI-2){
					if(oldI == chessboard.length-2 && chessboard[oldI-1][oldJ] == Chessmen.EMPTY ){
						return true;
					}else{
						System.err.print("Error: Pawn can't move two because someone's blocking the way");
						return false;
					}
				}
				//c. move upwards by 1
				else if(newI == oldI-1){
					if(chessboard[newI][newJ] == Chessmen.EMPTY){
						return true;
					}else{
						System.err.print("Error: Pawn can't move there two because someone's blocking the way");
						return false;
					}
				//d. Any other move than the above must be illegal
				}else{
					System.err.print("Error: Pawn can't perform this move");
					return false;
				}
			
			case BLACK_PAWN: 

				//a. checking sideways move 
				if( (newI == oldI +1 && newJ == oldJ +1) || (newI == oldI +1 && newJ == oldJ -1) ){
					if(chessboard[newI][newJ].toString().startsWith("W")){
						return true;
					}else{
						System.err.print("Error: PAWN can only move diagonally to kill an enemy");
						return false;
					}
				}
				//b. checking two steps upon initial move
				else if(newI == oldI+2){
					if(oldI == chessboard.length-7 && chessboard[oldI+1][oldJ] == Chessmen.EMPTY ){
						return true;
					}else{
						System.err.print("Error: Pawn can't move there because someone's blocking the way");
						return false;
					}
				}
				//c. move downwards by 1
				else if(newI == oldI+1){
					if(chessboard[newI][newJ] == Chessmen.EMPTY){
						return true;
					}else{
						System.err.print("Error: Pawn can't move there two because someone's blocking the way");
						return false;
					}
				//d. Any other move than the above must be illegal
				}else{
					System.err.print("Error: Pawn can't perform this move");
					return false;
				}
				
				
			case WHITE_ROOK: 
				//a. vertical movement without jump
				if( oldI-newI != 0 ){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.print("Error: illegal Rook move");
						return false; 
					}
					return true;
				//b. horizontal movement without jump
				}else if( oldJ-newJ != 0 ){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.print("Error: illegal Rook move");
						return false; 
					}
					return true;
				//c. any other move must be illegal
				}else{
					System.err.print("Error: illegal Rook move");
					return false;
				}
					
			case BLACK_ROOK: 
				//a. vertical movement without jump
				if( oldI-newI != 0 ){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.print("Error: illegal Rook move");
						return false; 
					}
					return true;
				//b. horizontal movement without jump
				}else if( oldJ-newJ != 0 ){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.print("Error: illegal Rook move");
						return false; 
					}
					return true;
				//c. any other move must be illegal
				}else{
					System.err.print("Error: illegal Rook move");
					return false;
				}
				
			case WHITE_KNIGHT:
				//right or left 2 movement
				if(Math.abs(oldJ-newJ) == 2){
					//up or down
					if(Math.abs(oldI-newI) == 1){
						return true;
					}
				}
				//up or down 2 movements
				else if(Math.abs(oldI-newI) == 2){
					if(Math.abs(oldJ-newJ) == 1){
						return true;
					}
				}
				else{
					System.err.print("Error: illegal Knight move");
					return false;
				}
				
			case BLACK_KNIGHT:
				//right or left 2 movement
				if(Math.abs(oldJ-newJ) == 2){
					//up or down
					if(Math.abs(oldI-newI) == 1){
						return true;
					}
				}
				//up or down 2 movements
				else if(Math.abs(oldI-newI) == 2){
					if(Math.abs(oldJ-newJ) == 1){
						return true;
					}
				}
				else{
					System.err.print("Error: illegal Knight move");
					return false;
				}
				
			case WHITE_KING:

				//diagonal movement
				if(Math.abs(oldJ-newJ) == 1 && Math.abs(oldI-newI) == 1){
					if(!diagonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: can't move more than 1 field diagonally");
						return false;
					}
					return true;
				}
				//up or down
				else if(Math.abs(oldI-newI) == 1){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: can't move more than 1 field vertically");
						return false;
					}
					return true;
				}
				//right or left
				else if(Math.abs(oldJ-newJ) == 1){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: can't move more than 1 field horizontally");
						return false;
					}
					return true;
				}
				//all other cases
				else{
					System.err.println("Error: King can only move 1 step");
					return false;
				}
			
			case BLACK_KING:

				//diagonal movement
				if(Math.abs(oldJ-newJ) == 1 && Math.abs(oldI-newI) == 1){
					if(!diagonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: can't move more than 1 field diagonally");
						return false;
					}
					return true;
				}
				//up or down
				else if(Math.abs(oldI-newI) == 1){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: can't move more than 1 field vertically");
						return false;
					}
					return true;
				}
				//right or left
				else if(Math.abs(oldJ-newJ) == 1){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: can't move more than 1 field horizontally");
						return false;
					}
					return true;
				}
				//all other cases
				else{
					System.err.println("Error: King can only move 1 step");
					return false;
				}
				
				
			case WHITE_BISHOP:
				if(!diagonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
					System.err.println("Error: diagonalIsValid jumped over a figure");
					return false;
				}
				else{
					return true;
				}
			
			case BLACK_BISHOP:
				if(!diagonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
					System.err.println("Error: diagonalIsValid jumped over a figure");
					return false;
				}
				else{
					return true;
				}
				
				
			case WHITE_QUEEN:
				//orthogonal movement
				if(oldJ-newJ == 0 && oldI-newI != 0 || oldJ-newJ != 0 && oldI-newI == 0 ){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: orthogonalIsValid jumped over a figure");
						return false;
					}
					return true;
				}
				//diagonal movement
				else if(oldJ-newJ != 0 && oldI-newI != 0 ){
					if(!diagonalIsValid(chessboard, oldI, oldJ, newI, newJ) ){
						System.err.print("Error: diagonalIsValid returned false");
						return false; 
					}
					return true;
				}
				//everything else is prohibited
				else{
					System.err.println("Error: default false");
					return false;	
				}
								
			case BLACK_QUEEN:
				//orthogonal movement
				if(oldJ-newJ == 0 && oldI-newI != 0 || oldJ-newJ != 0 && oldI-newI == 0 ){
					if(!orthogonalIsValid(chessboard, oldI, oldJ, newI, newJ)){
						System.err.println("Error: orthogonalIsValid jumped over a figure");
						return false;
					}
					return true;
				}
				//diagonal movement
				else if(oldJ-newJ != 0 && oldI-newI != 0 ){
					if(!diagonalIsValid(chessboard, oldI, oldJ, newI, newJ) ){
						System.err.print("Error: diagonalIsValid returned false");
						return false; 
					}
					return true;
				}
				//everything else is prohibited
				else{
					System.err.println("Error: default false");
					return false;	
				}
				
				
			//eventual meaning: can't make no move == placing .EMPTY into another field	
			default: 
				System.err.println("Switch default error");
				return false;
							
		//end of Switch statement
		}	
	// end of isValid method 
	}
			
	public static Boolean orthogonalIsValid(Chessmen[][] chessboard, int oldI, int oldJ, int newI, int newJ){
		
		//horizontal movement
		if(oldI-newI == 0){
			//left movement
			if(oldJ-newJ > 0){
				for(int a = oldJ-1 ; a > newJ ; a-- ){
					if(chessboard[oldI][a] != Chessmen.EMPTY){
						System.err.println("Error: orthogonalIsValid left movement");
						return false;
					}
				}
				return true;
			}
			//else right movement
			else{
				for(int b = oldJ+1 ; b < newJ ; b++ ){
					if(chessboard[oldI][b] != Chessmen.EMPTY){
						System.err.println("Error: orthogonalIsValid right movement");
						return false;
					}
				}
				return true;
			}
		}
		//vertical movement
		else if(oldJ-newJ == 0 ){
			//upward movement
			if(oldI-newI > 0){
				for(int c = oldI-1 ; c > newI ; c--){
					if(chessboard[c][oldJ] != Chessmen.EMPTY){
						System.err.println("Error: orthogonalIsValid upward movement");
						return false;
					}
				}
				return true;
			}		
			//downward movement
			else{
				for(int c = oldI+1 ; c < newI ; c++){
					if(chessboard[c][oldJ] != Chessmen.EMPTY){
						System.err.println("Error: orthogonalIsValid downward movement");
						return false;
					}
				}
				return true;
			}
		}

		System.err.println("Error: orthogonalIsValid returned default false");
		return false;
	}

	public static Boolean diagonalIsValid(Chessmen[][] chessboard, int oldI, int oldJ, int newI, int newJ){
		//1. quadrant diagonal (top right)
		if(oldI-newI > 0 && oldJ-newJ < 0){
			for(int a = oldI-1 ; a > newI ; a--){
				for(int b = oldJ+1 ; b < newJ ; b++){
					if(chessboard[a][b] != Chessmen.EMPTY){
						System.err.println("Error: diagonalIsValid jumped a piece in 1. quadrant diagonal");
						return false;
					}
				}
			}
			return true;
		}
		//2. quadrant diagonal (top left)
		else if(oldI-newI > 0 && oldJ-newJ > 0){
			for(int a = oldI-1 ; a > newI ; a--){
				for(int b = oldJ-1 ; b > newJ ; b--){
					if(chessboard[a][b] != Chessmen.EMPTY){
						System.err.println("Error: diagonalIsValid jumped a piece in 2. quadrant diagonal");
						return false;
					}
				}
			}
			return true;
		}
		//3. quadrant diagonal (bottom left)
		else if(oldI-newI < 0 && oldJ-newJ > 0){
			for(int a = oldI+1 ; a < newI ; a++){
				for(int b = oldJ-1 ; b > newJ ; b--){
					if(chessboard[a][b] != Chessmen.EMPTY){
						System.err.println("Error: diagonalIsValid jumped a piece in 3. quadrant diagonal");
						return false;
					}
				}
			}
			return true;
		}
		//4. quadrant diagonal (bottom right)
		if(oldI-newI < 0 && oldJ-newJ < 0){
			for(int a = oldI+1 ; a < newI ; a++){
				for(int b = oldJ+1 ; b < newJ ; b++){
					if(chessboard[a][b] != Chessmen.EMPTY){
						System.err.println("Error: diagobalIsValid jumped a piece in 4. quadrant diagonal");
						return false;
					}
				}
			}
			return true;
		}
		else{
			System.err.println("Error: diagonalIsValid else error");
			return false;
		}
	}		
}



	