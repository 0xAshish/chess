import javax.swing.JPanel;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;

public class MouseInput extends Input {
  
  private Screen _screen;
  
  MouseInputGetter MIG;
  
  @Override
  public int[] getMove() throws InterruptedException, ExecutionException {
    MIG = new MouseInputGetter(_screen);
    MIG.execute();
    return MIG.get();
  }

  @Override
  public boolean playAgain() {
    return false;
  }

  @Override
  public void setScreen(Screen screen) {
    _screen = screen;
  }
  
}
