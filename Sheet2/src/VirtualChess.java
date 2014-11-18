import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VirtualChess {

	/*
	Hint: enums are used to express fixed sets of constants throughout your program,
	and because they are constants, we type-set them in UPPER CASE.
	Similarly, you could have enum for days of week ( MONDAY, TUESDAY...),
	compass directions (NORTH, WEST...) etc.
	 */
	static int count = 2;
	static String [] alphabet = {"a","b","c","d","e","f","g","h"};
	static String [] numberindex = {"8","7","6","5","4","3","2","1"};
	static List<Chessmen> black = Arrays.asList(Chessmen.BLACK_KING, Chessmen.BLACK_QUEEN, 
			Chessmen.BLACK_ROOK, Chessmen.BLACK_BISHOP, Chessmen.BLACK_KNIGHT, Chessmen.BLACK_PAWN);
	static List<Chessmen> white = Arrays.asList(Chessmen.WHITE_KING, Chessmen.WHITE_QUEEN, 
			Chessmen.WHITE_ROOK, Chessmen.WHITE_BISHOP, Chessmen.WHITE_KNIGHT, Chessmen.WHITE_PAWN);
	static List<Chessmen> blackp = Arrays.asList(Chessmen.BLACK_KING, Chessmen.BLACK_QUEEN, 
			Chessmen.BLACK_ROOK, Chessmen.BLACK_BISHOP, Chessmen.BLACK_KNIGHT, Chessmen.BLACK_PAWN);
	static List<Chessmen> whitep = Arrays.asList(Chessmen.WHITE_KING, Chessmen.WHITE_QUEEN, 
			Chessmen.WHITE_ROOK, Chessmen.WHITE_BISHOP, Chessmen.WHITE_KNIGHT, Chessmen.WHITE_PAWN);


	//inside name of call function, is the value in main
	//when initialising function, inside name is the argument which is only stored temporarily





	public static int move (Chessmen[][] chessboard, String move, int count){
		//parse move string into components

		String[] components = move.split(" ");

		System.out.println(Arrays.toString(components));

		int fromY = getIndexOf(components[0].charAt(0));
		int fromX = getIndexOfN(components[0].charAt(1));
		int toY = getIndexOf(components[2].charAt(0));
		int toX = getIndexOfN(components[2].charAt(1));

		//		int fromx_int = Character.getNumericValue(components[0].charAt(0))-10;
		//		int fromy_int = -(Character.getNumericValue(components[0].charAt(1))-8);
		//		int tox_int = Character.getNumericValue(components[2].charAt(0))-10;
		//		int toy_int = -(Character.getNumericValue(components[2].charAt(1))-7);


		System.out.println("atStart=" + chessboard[fromX][fromY]);
		System.out.println("destination=" + chessboard[toX][toY]);

		//use function to return numbers instead of alphabets
		Chessmen atStart = chessboard[fromX][fromY];

		if (isValid(chessboard, atStart, fromY, fromX, toY, toX)==true){
			chessboard[fromX][fromY] = Chessmen.EMPTY;
			chessboard[toX][toY] = atStart;
			//System.out.println("count1: " + count);
			return count++; // what should it be??
		} else { 
			//System.out.println("count0: " + count);
			return count; // what should it be?
		}

	} // end move

	// end move
	public static boolean isValid(Chessmen[][] chessboard, Chessmen atStart, int fromY, int fromX, int toY, int toX){
		//String turn = playerColour(count);
		if (isEmpty(chessboard, atStart, fromY, fromX, toY, toX)) {
			if (isDifferent(chessboard, fromY, fromX, toY, toX)) {
				//if (rightTurn(chessboard, fromY, fromX, toY, toX, turn)){

				return true;
			} else {
				System.err.println("Error Message");
				//}
			}
		}
		return false;

	} //end boolean isValid




	// end move
	public static boolean isEmpty (Chessmen [][] chessboard, Chessmen atStart, int fromY, int fromX, int toY, int toX) {
		boolean isValid = false; 
		if (atStart != Chessmen.EMPTY){
			return isValid = true;
		} else {
			System.out.println("Cannot start from empty.");
		}

		return isValid;
	}


	public static boolean isDifferent (Chessmen [][] chessboard, int fromY, int fromX, int toY, int toX){
		if(black.contains(chessboard[fromX][fromY]) && black.contains(chessboard[toX][toY])){
			System.out.println("Cannot kill yer own pieces.");
			return false;
		}
		else if (white.contains(chessboard[fromX][fromY]) && white.contains(chessboard[toX][toY])){
			System.out.println("Cannot kill yer own pieces.");
			return false;
		} 
		else {

			return true;	
		}
	}

	public static boolean rightTurn(Chessmen [][] chessboard, int fromY, int fromX, int toY, int toX, String player){
		if (player=="White" &&  whitep.contains(chessboard[fromX][fromY])){
			System.out.println(player);
			return true;
		}
		if (player=="black" && blackp.contains(chessboard[fromX][fromY])){
			System.out.println(player);
			return true;
		} else {
			System.out.println("Cannot use other's pieces.");
			return false;
		}
	}

	//	}
	//	public static String playerColour (int count){
	//		String player = null;
	//		if (count%2 == 1){
	//			player = "Black";
	//		}
	//		if (count%2 == 0){
	//			player = "White";
	//		}
	//		return player;
	//	}

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

	public static void assignChess (Chessmen[][] chessboard) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0){
					chessboard[i][0] = Chessmen.BLACK_ROOK;
					chessboard[i][1] = Chessmen.BLACK_KNIGHT;
					chessboard[i][2] = Chessmen.BLACK_BISHOP;
					chessboard[i][3] = Chessmen.BLACK_KING;
					chessboard[i][4] = Chessmen.BLACK_QUEEN;
					chessboard[i][5] = Chessmen.BLACK_BISHOP;
					chessboard[i][6] = Chessmen.BLACK_KNIGHT;
					chessboard[i][7] = Chessmen.BLACK_ROOK;

				} else if (i == 1){
					chessboard[i][j] = Chessmen.BLACK_PAWN;
				} else if (i >= 2 && i <= 5){
					chessboard [i][j] = Chessmen.EMPTY;
				} else if (i == 6){
					chessboard[i][j] = Chessmen.WHITE_PAWN;
				} else if (i == 7) {
					chessboard[i][0] = Chessmen.WHITE_ROOK;
					chessboard[i][1] = Chessmen.WHITE_KNIGHT;
					chessboard[i][2] = Chessmen.WHITE_BISHOP;
					chessboard[i][3] = Chessmen.WHITE_KING;
					chessboard[i][4] = Chessmen.WHITE_QUEEN;
					chessboard[i][5] = Chessmen.WHITE_BISHOP;
					chessboard[i][6] = Chessmen.WHITE_KNIGHT;
					chessboard[i][7] = Chessmen.WHITE_ROOK;
				}
			}
		} // end for loop assigning chess pieces to chess board
	} // end assignChess



	public static void printBoard (Chessmen[][] chessboard) {
		//Use "\t" for placing tabs in strings. This will help you align
		//individual columns in your chessboard.
		// for i rows
		for (int i = 0; i < 8; i++) {
			System.out.print("\t" + alphabet[i]);
		}

		System.out.println(); // space in between index and chess piece


		for (int i = 0; i < 8; i++) {
			System.out.println();
			System.out.print(numberindex [i] + "." + "\t");

			for (int j = 0; j < 8; j++){
				switch (chessboard[i][j]){
				case WHITE_KING:
					System.out.print("♔");
					break;
				case WHITE_QUEEN:
					System.out.print("♕");
					break;
				case WHITE_ROOK:
					System.out.print("♖");
					break;
				case WHITE_BISHOP:
					System.out.print("♗");
					break;
				case WHITE_KNIGHT:
					System.out.print("♘");
					break;
				case WHITE_PAWN:
					System.out.print("♙");
					break;
				case BLACK_KING:
					System.out.print("♚");
					break;
				case BLACK_QUEEN:
					System.out.print("♛");
					break;
				case BLACK_ROOK:
					System.out.print("♜");
					break;
				case BLACK_BISHOP:
					System.out.print("♝");
					break;
				case BLACK_KNIGHT:
					System.out.print("♞");
					break;
				case BLACK_PAWN:
					System.out.print("♟");
					break;
				case EMPTY:
					System.out.print("");
					break;
				}
				System.out.print( "\t");
			}
			System.out.println();
		} // end for loop
	} // end printboard function


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



	public static void main (String [] args) {
		// create a chess board matrix.
		//It is an array of arrays (hence matrix) of size 8 * 8
		Chessmen[][] chessboard = new Chessmen[8][8];

		Scanner read = new Scanner(System.in);
		assignChess(chessboard);
		boolean exit = false;	


		while (exit == false){

			printBoard(chessboard);
			System.out.println("Which chess piece to where?" + "\n" + "Enter value of column and row as " + "x0 to x0");
			System.out.println("Player 1: Type in moves.");
			String input = read.nextLine();

			//System.out.println("This is what it should be next!0 " + playerColour(count));
			int newCount = move(chessboard, input, count);
			printBoard(chessboard);

			//System.out.println(count);

			System.out.println("Next player's turn.");
			input = read.nextLine();

			//System.out.println("This is what it should be next!1 " + playerColour(count));
			newCount = move(chessboard, input, count);

			printBoard(chessboard);

			//System.out.println(count);


			System.out.println("Keep playing or exit?");
			input = read.nextLine();

			if (input.equals("exit")){
				exit = true;
				System.exit(0);	
			}
		} // end while
	} // end main
} // end class


