package pieces;


public class Knight extends AbstractPiece {
	
	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if(isWhite == true) {
			System.out.print("\u2658" + "\t");
		} else {
			System.out.print("\u265E" + "\t");
		}
	}
	@Override
	public boolean isMoveValid(int row1, int col1, int row2, int col2) {
		int deltaRow = Math.abs(row2-row1);
		int deltaCol = Math.abs(col2-col1);
		
		if (!((deltaRow==2 && deltaCol==1) || (deltaRow==1 && deltaCol==2))) {
			System.out.println("Knight Error");
			return false;
		}
		return true;
	}

	@Override
	public int relativeValue() {
		// TODO Auto-generated method stub
		return 3;
	}

}
