package pieces;


public class Queen extends AbstractPiece {
	
	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if(isWhite == true) {
			System.out.print("\u2655" + "\t");
		} else {
			System.out.print("\u265B" + "\t");
		}
	}

	@Override
	public boolean isMoveValid(int row1, int col1, int row2, int col2) {
		int deltaRow = Math.abs(row2-row1);
		int deltaCol = Math.abs(col2-col1);
		
		if (deltaRow!=deltaCol&&deltaRow!=0&&deltaCol!=0) {
			System.out.println("Queen Error");
			return false;
		}
		return true;
	}

	@Override
	public int relativeValue() {
		// TODO Auto-generated method stub
		return 9;
	}

}
