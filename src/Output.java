import javax.swing.JPanel;


public abstract class Output {
  
  // show board and pieces to user
  public abstract void displayBoard(Board chessBoard);

  // tell user his move was invalid
  public abstract void invalidMove();

  // congratulate the winner of color
  public abstract void displayWinner(int color);

  public abstract Screen getScreen();

}
