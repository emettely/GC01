package pieces;

public abstract class AbstractPiece {
	
	boolean isWhite;
		
	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	public boolean isWhite() {
		return isWhite;
	}
	
	public abstract void draw();
	
	public abstract boolean isMoveValid(int row1, int col1, int row2, int col2);
	
	public abstract int relativeValue();
}

