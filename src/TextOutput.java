import javax.swing.JPanel;


public class TextOutput extends Output {

  @Override
  public void displayBoard(Board chessBoard) {
    System.out.println(chessBoard);
  }

  @Override
  public void invalidMove() {
    System.out.println("Invalid Move! Try again...");
  }

  @Override
  public void displayWinner(int color) {
    if (color == Piece.BLACK) {
      System.out.println("Black Wins!");
    }
    else if (color == Piece.WHITE) {
      System.out.println("White Wins!");
    }
    
  }

  @Override
  public Screen getScreen() {
    // there is no screen bro
    return null;
  }

}
