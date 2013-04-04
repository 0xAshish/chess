import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;


public class Board {
  public static final int SIZE = 8;
  
  private Cell[][] _cells;
  
  public Board() throws IOException {
    reset();
  }
  
  public void reset() throws IOException {
    int x, y, color;
    
    // [width][height]
    _cells = new Cell[SIZE][SIZE];
    for (x = 0; x < SIZE; x++) {
      for (y = 0; y < SIZE; y++) {
        _cells[x][y] = new Cell();
      }
    }

    //set up black pieces
    color = Piece.BLACK;
    _cells[0][0].setPiece( new Rook(color) );
    _cells[1][0].setPiece( new Knight(color) );
    _cells[2][0].setPiece( new Bishop(color) );
    _cells[3][0].setPiece( new Queen(color) );
    _cells[4][0].setPiece( new King(color) );
    _cells[5][0].setPiece( new Bishop(color) );
    _cells[6][0].setPiece( new Knight(color) );
    _cells[7][0].setPiece( new Rook(color) );
    for (x = 0; x < SIZE; x++) {
      _cells[x][1].setPiece( new Pawn(color, 1) );
    }
    
    //set up white pieces
    color = Piece.WHITE;
    _cells[0][7].setPiece( new Rook(color) );
    _cells[1][7].setPiece( new Knight(color) );
    _cells[2][7].setPiece( new Bishop(color) );
    _cells[3][7].setPiece( new King(color) );
    _cells[4][7].setPiece( new Queen(color) );
    _cells[5][7].setPiece( new Bishop(color) );
    _cells[6][7].setPiece( new Knight(color) );
    _cells[7][7].setPiece( new Rook(color) );
    for (x = 0; x < SIZE; x++) {
      _cells[x][6].setPiece( new Pawn(color, -1) );
    }
  }
  
  public boolean canWin(int goodColor) {
    //checks to see if goodColor could capture enemy king
    //looks at all possible good moves and if enemy king is 
    // a possible move you win
    
    ArrayList<ArrayList<int[]>> allMoves = new ArrayList<ArrayList<int[]>>();
    int[] enemyKingPos = null;
    int x, y;
    
    for (y = 0; y < SIZE; y++) {
      for (x = 0; x < SIZE; x++) {
        if (!emptyAt(x,y) && getColorAt(x,y) == goodColor) {
          allMoves.add(_cells[x][y].getPiece().allPossibleMoves(x, y, this) );
        }
        if (!emptyAt(x,y) && _cells[x][y].getPiece().getColor() != goodColor && _cells[x][y].getPiece() instanceof King) {
          enemyKingPos = new int[]{x, y};
        }
      }
    }
    
    int i,j;
    ArrayList<int[]> moves;
    for (i = 0; i < allMoves.size(); i++) {
      moves = allMoves.get(i);
      for (j = 0; j < moves.size(); j++) {
        if (moves.get(j)[0] == enemyKingPos[0] && moves.get(j)[1] == enemyKingPos[1]) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  public boolean emptyAt(int x, int y) {
    if (!onBoard(x, y)) {
      return false;
    }
    return !_cells[x][y].hasPiece();
  }
  
  public int getColorAt(int x, int y) {
    return _cells[x][y].getPiece().getColor();
  }
  
  public boolean validMove(int startX, int startY, int requestedX, int requestedY, int color) {
    
    Piece p;
    
    if (onBoard(startX, startY) && onBoard(requestedX, requestedY)) {
      p = _cells[startX][startY].getPiece();
      return p != null && p.getColor() == color && p.validMove(startX, startY, requestedX, requestedY, this);
    }
    
    return false;
  }
  
  public boolean onBoard(int x, int y) {
    return (x < SIZE && x >= 0 && y < SIZE && y >= 0);
  }

  public void doMove(int[] move) {
    // move piece at (move[0], [1]) to ([2], [3])
    _cells[move[2]][move[3]].setPiece(_cells[move[0]][move[1]].getPiece());
    _cells[move[0]][move[1]].getPiece().setMoved(true);
    _cells[move[0]][move[1]].makeEmpty();

    
  }
  
  public Image getPieceImageAt(int x, int y) {
    return _cells[x][y].getPiece().getImage();
  }
  
  public String toString() {
    int x, y;
    String result = " ";
    
    for (x = 0; x < SIZE; x++) {
      result += x;
    }
    result += "\n";
    
    for (y = 0; y < SIZE; y++) {
      result += y;
      for (x = 0; x < SIZE; x++) {
        if (emptyAt(x, y)) {
          result += ".";
        }
        else {
          result += _cells[x][y].getPiece();
        }
      }
      result += "\n";
    }
    
    return result;
  }
}
