package pieces;

public class Pawn extends AbstractPiece {

	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if(isWhite == true) {
			System.out.print("\u2659" + "\t");
		} else {
			System.out.print("\u265F" + "\t");
		}
	}


	@Override
	public boolean isMoveValid(int row1, int col1, int row2, int col2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int relativeValue() {
		// TODO Auto-generated method stub
		return 1;
	}

}
