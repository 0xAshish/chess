import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;


public abstract class Input {
  
  public abstract int[] getMove() throws InterruptedException, ExecutionException;
  
  public abstract boolean playAgain();

  public abstract void setScreen(Screen screen);
}
