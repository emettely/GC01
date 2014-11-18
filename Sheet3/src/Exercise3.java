
import java.util.Arrays;
import java.util.Scanner;

import pieces.AbstractPiece;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Exercise3 {

	public static final int chessPiece = 8;
	static int playerNumber = 1, whiteScore = 0, blackScore = 0;
	static String [] alphabet = {"a","b","c","d","e","f","g","h"};
	static String [] numberindex = {"8","7","6","5","4","3","2","1"};
	private static Scanner read;

	public static int getIndexOf(char input) {
		if(input == 'a') {
			return 0;
		} else if(input == 'b') {
			return 1;
		} else if(input == 'c') {
			return 2;
		}else if(input == 'd') {
			return 3;
		}else if(input == 'e') {
			return 4;
		}else if(input == 'f') {
			return 5;
		}else if(input == 'g') {
			return 6;
		}else if(input == 'h'){
			return 7;
		} else {
			return -1;
		}
	} // end getindexof



	public static int getIndexOfN(char input) {
		if(input == '8') {
			return 0;
		} else if(input == '7') {
			return 1;
		}else if(input == '6') {
			return 2;
		}else if(input == '5') {
			return 3;
		}else if(input == '4') {
			return 4;
		}else if(input == '3') {
			return 5;
		}else if(input == '2') {
			return 6;
		}else if(input == '1'){
			return 7;
		}else {
			return -1;
		}
	} //end getindexof N



	public static void printBoard(AbstractPiece[][] chessboard) {
		//Draw() method
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for(int i = 0; i < chessboard.length; i++) {
			System.out.print(8-i + ".\t");
			for(int j = 0; j < chessboard[i].length; j++) {
				if(chessboard[i][j] != null){
					chessboard[i][j].draw();
				} else {
					System.out.print("\t");
				}
				if(j == 7){
					System.out.print("\n");
				}

			}
		}
		//end Draw() method
	}



	public static void move (AbstractPiece[][] chessboard, String move, int count){

		//parse move string into components

		String[] components = move.split(" ");


		System.out.println(Arrays.toString(components));

		int col1 = getIndexOf(components[0].charAt(0));
		int row1 = getIndexOfN(components[0].charAt(1));
		int col2 = getIndexOf(components[2].charAt(0));
		int row2 = getIndexOfN(components[2].charAt(1));


		//		System.out.println("atStart=" + chessboard[fromX][fromY]);
		//		System.out.println("destination=" + chessboard[toX][toY]);
		//		use function to return numbers instead of alphabets
		//		AbstractPiece atStart = chessboard[fromX][fromY];


		//after it is valid, check for player number, if chess isnt empty and coloured, to add scores
		if(isValid(chessboard, row1, col1, row2, col2) == true) {

			if(playerNumber == 1) {
				if(chessboard[row2][col2]!=null){
					if(!(chessboard[row2][col2].isWhite())) {
						whiteScore += chessboard[row2][col2].relativeValue();
					}
				}
			}

			if(playerNumber == 2) {
				if(chessboard[row2][col2]!=null){
					if(chessboard[row2][col2].isWhite()){
						blackScore += chessboard[row2][col2].relativeValue();
					}
				}
			}

			chessboard[row2][col2] = chessboard[row1][col1]; 
			chessboard[row1][col1] = null;
			if(playerNumber == 1) {
				playerNumber = 2;
			} else {
				playerNumber = 1;
			}

			//print scores if valid

			System.out.printf("------Scores------\nWhite-%d : Black-%d\n------------------\n", whiteScore, blackScore);
		} else {
			System.out.println("\nError! Move is not valid!\n");
		}
	}




	// end move
	public static boolean isValid(AbstractPiece[][] chessboard, int row1, int col1, int row2, int col2){
		//String turn = playerColour(count);
		if (isEmpty(chessboard, row1, col1, row2, col2)) {System.out.println("1"); return false;}

		if (isDifferent(chessboard, row1, col1, row2, col2)) {System.out.println("2"); return false;}

		if (outOfBounds(chessboard, row1, col1, row2, col2)) {System.out.println("3"); return false;}

		if(!((AbstractPiece) chessboard[row1][col1]).isMoveValid(row1, col1, row2, col2)) {System.out.println("4"); return false;}

		return true;

	} //end boolean isValid



	// end move
	public static boolean isEmpty (AbstractPiece [][] chessboard, int row1, int col1, int row2, int col2) {
		if(chessboard[row1][col1] == null) {
			System.out.println("Cannot start from empty.");
			return true;
		} 

		return false;
	}

	public static boolean isDifferent (AbstractPiece[][] chessboard, int row1, int col1, int row2, int col2){
		if(row2 == row1 && col2 == col1) {
			return true;
		}
		return false;
	}


	public static boolean outOfBounds (AbstractPiece[][] chessboard, int row1, int col1, int row2, int col2) {
		if(row1 < 0 || row1 > 7) {
			return true;
		}

		if(row2 < 0 || row2 > 7) {
			return true;
		}

		if(col1 < 0 || col1 > 7) {
			return true;
		}

		if(col2 < 0 || col2 > 7) {
			return true;
		}
		return false;
	}



	public static boolean turn(AbstractPiece[][] chessboard,
			int row1, int col1, int row2, int col2, int playerNumber){
		//check if color is correct
		if(playerNumber == 1) {
			if(chessboard[row1][col1].isWhite() == false) {
				return false;
			}
		}

		if(playerNumber == 2) {
			if(chessboard[row1][col2].isWhite() == true) {
				return false;
			}
		}
		return true;

		// end color check


	}
	public static void main (String [] args) {

		//chessboard

		AbstractPiece[][] chessboard = new AbstractPiece[chessPiece][chessPiece];

		//empty initially
		for(AbstractPiece[] AP : chessboard){
			for(AbstractPiece A : AP){
				A = null;
			}
		}

		//Piece parameter - white, black names, row definitions

		//White Pieces
		chessboard[7][0] = new Rook(true);
		chessboard[7][1] = new Knight(true);
		chessboard[7][2] = new Bishop(true);
		chessboard[7][3] = new Queen(true);
		chessboard[7][4] = new King(true);
		chessboard[7][5] = new Bishop(true);
		chessboard[7][6] = new Knight(true);
		chessboard[7][7] = new Rook(true);
		//end White Pieces

		//Black Pieces
		chessboard[0][0] = new Rook(false);
		chessboard[0][1] = new Knight(false);
		chessboard[0][2] = new Bishop(false);
		chessboard[0][3] = new Queen(false);
		chessboard[0][4] = new King(false);
		chessboard[0][5] = new Bishop(false);
		chessboard[0][6] = new Knight(false);
		chessboard[0][7] = new Rook(false);
		//end Black Pieces


		//White Pawns
		for(int j = 0; j < chessboard.length; j++) {
			chessboard[6][j] = new Pawn(true);
		}
		//end White Pawns


		//Black Pawns
		for(int j = 0; j < chessboard.length; j++) {
			chessboard[1][j] = new Pawn(false);
		}
		//end Black Pawns


		//Empty spaces

//		for(int i = 2; i <= 5; i++) {
//			for(int j = 0; j <= chessPiece-1; j++) {
//				chessboard[i][j] = null;
//			}
//		}

		//end Empty Spaces


		//talking to player
		boolean exit = false;	

		while (exit == false){

			read = new Scanner(System.in);
			printBoard(chessboard);

			System.out.println("Which chess piece to where?" + "\n" + "Enter value of column and row as " + "x0 to x0");
			System.out.println("or type exit to exit");
			System.out.println("Player" + playerNumber + ": Type in moves.");

			String input = read.nextLine();

			//Exit line to finish

			if (input.equals("exit")){
				exit = true;
				System.exit(0);	

			}

			move(chessboard, input, playerNumber);
			System.out.println();

		} // end while
	}


} // end class