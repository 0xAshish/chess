import java.io.IOException;
import java.util.ArrayList;


public class King extends Piece {

  public King(int color) throws IOException {
    super(color);
  }

  @Override
  protected ArrayList<int[]> allPossibleMoves(int currentX, int currentY, Board board) {
    ArrayList<int[]> moves = new ArrayList<int[]>();
    int x,y;
    
    for (x = -1; x <= 1; x++) {
      for (y = -1; y <= 1; y++) {
        // cannot move to self
        if (!(x == 0 && y == 0)) {
          // if on board, and is empty or is enemy
          if (board.onBoard(currentX+x, currentY+y) 
              && (board.emptyAt(currentX + x, currentY + y) || board.getColorAt(currentX+x, currentY+y) != _color)) {
            moves.add(new int[]{currentX+x, currentY+y});
          }
        }
      }
    }
    
    return moves;
    
  }
  
  public String toString() {
    return "K";
  }

}
