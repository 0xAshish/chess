
public class Cell {
  public static final int SIZE = 62;
  private Piece _piece;
  private boolean _empty;
  
  public Cell() {
    _empty = true;
  }
  
  public Cell(Piece p) {
    _empty = false;
    _piece = p;
  }
  
  public boolean hasPiece() {
    return !_empty;
  }
  
  public Piece getPiece() {
    return _piece;
  }
  
  public void setPiece(Piece p) {
    _piece = p;
    _empty = false;
  }
  
  public void makeEmpty() {
    _empty = true;
    _piece = null;
  }
}
