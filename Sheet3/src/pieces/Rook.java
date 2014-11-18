package pieces;

public class Rook extends AbstractPiece {

	public Rook(boolean isWhite) {
		super(isWhite);
	}
	public int relativeValue() {
		// TODO Auto-generated method stub
		return 5;
	}
	public void draw() {
		// TODO Auto-generated method stub
		if(isWhite) {
			System.out.print("\u2656" + "\t");
		} else {
			System.out.print("\u265C" + "\t");
		}
	}

	@Override
	public boolean isMoveValid(int row1, int col1, int row2, int col2) {
		int deltaRow = Math.abs(row2-row1);
		int deltaCol = Math.abs(col2-col1);
		if (deltaRow!=0&&deltaCol!=0) {
			System.out.println("Rook Error");
			return false;
		}
		return true;
	}
}

