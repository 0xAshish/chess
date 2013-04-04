import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Chess {
  public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
    
    int inputType = getInterfaceType(args);
    
    Game g = new Game(inputType);
    boolean again = true;
    
    while (again) {
      g.play();
      again = g.playAgain();
    }
    
  }
  
  public static int getInterfaceType(String[] args) {
    
    if (args.length > 0) {
      if (args[0].equalsIgnoreCase("gui")) {
        return InputConstructor.GUI;
      }
      else if (args[0].equalsIgnoreCase("text")) {
        return InputConstructor.TEXT;
      }
    }

    //defaults to keyboard input/output
    return InputConstructor.GUI;
    
  }
  
}
