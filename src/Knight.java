import java.io.IOException;
import java.util.ArrayList;


public class Knight extends Piece {

  public Knight(int color) throws IOException {
    super(color);
  }

  @Override
  protected ArrayList<int[]> allPossibleMoves(int currentX, int currentY, Board board) {
    ArrayList<int[]> moves = new ArrayList<int[]>();
    int x,y;
    
    // left and right two spaces
    for (x = -2; x < 3; x += 4) {
      // up and down one space
      for (y = -1; y < 2; y += 2) {
        // if on board and is enemy or empty
        if (board.onBoard(currentX+x, currentY+y) 
            && !(board.emptyAt(currentX+x, currentY+y) == false && board.getColorAt(currentX+x, currentY+y) == _color)) {
          moves.add(new int[]{currentX+x, currentY+y});
        }
      }
    }
    
    // up and down two spaces
    for (y = -2; y < 3; y += 4) {
      // left and right one space
      for (x = -1; x < 2; x += 2) {
        // if on board and is enemy or empty
        if (board.onBoard(currentX+x, currentY+y) 
            && !(board.emptyAt(currentX+x, currentY+y) == false && board.getColorAt(currentX+x, currentY+y) == _color)) {
          moves.add(new int[]{currentX+x, currentY+y});
        }
      }
    }
    
    return moves;
  }
  
  public String toString() {
    return "N";
  }

}
