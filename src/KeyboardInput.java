import java.util.Scanner;

import javax.swing.JPanel;


public class KeyboardInput extends Input {
  
  private Scanner _scan;
  
  public KeyboardInput() {
    _scan = new Scanner(System.in);
  }

  @Override
  public int[] getMove() {
    int[] move = new int[4];
    
    System.out.print("Move which piece? (x,y seperated by space) :");
    move[0] = _scan.nextInt();
    move[1] = _scan.nextInt();
    
    System.out.print("Move to where? (x,y seperated by space) :");
    move[2] = _scan.nextInt();
    move[3] = _scan.nextInt();
    
    return move;
  }

  @Override
  public boolean playAgain() {
    System.out.print("Want to play again? (y/n)?");
    return _scan.next().equalsIgnoreCase("y");
  }

  @Override
  public void setScreen(Screen screen) {
    // do nothing
  }

}
