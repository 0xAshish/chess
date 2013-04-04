import java.io.IOException;
import java.util.ArrayList;


public class Pawn extends Piece {
  
  // pawn will advance in this direction. 
  private int _direction;
  
  public Pawn(int color, int direction) throws IOException {
    super(color);
    _hasMoved = false;
    // direction can only be 1 or -1
    _direction = direction/Math.abs(direction);
  }

  @Override
  protected ArrayList<int[]> allPossibleMoves(int currentX, int currentY, Board board) {
    ArrayList<int[]> moves = new ArrayList<int[]>();
    
    // 1 forward and 2 forward
    if (board.onBoard(currentX, currentY+_direction) && board.emptyAt(currentX, currentY+_direction)) {
      moves.add(new int[]{currentX, currentY+_direction});
      // pawn can only move two spaces on first turn
      if (board.onBoard(currentX, currentY+_direction*2) && board.emptyAt(currentX, currentY+_direction*2) && _hasMoved == false) {
        moves.add(new int[]{currentX, currentY+_direction*2});
      }
    }
    
    // right diagonal attack
    if (board.onBoard(currentX+1, currentY+_direction) && !board.emptyAt(currentX+1, currentY+_direction) && board.getColorAt(currentX+1, currentY+_direction) != _color) {
      moves.add(new int[]{currentX+1, currentY+_direction});
    }
    
    // left diagonal attack
    if (board.onBoard(currentX-1, currentY+_direction) && !board.emptyAt(currentX-1, currentY+_direction) && board.getColorAt(currentX-1, currentY+_direction) != _color) {
      moves.add(new int[]{currentX-1, currentY+_direction});
    }
    
    return moves;
  }
  
  public String toString() {
    return "P";
  }

}
