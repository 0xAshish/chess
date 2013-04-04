
public class InputConstructor {
  public static final int GUI = 1;
  public static final int TEXT = 2;
  
  public Input constructInput(int inputType) {
    
    if (inputType == GUI) {
      return new MouseInput();
    } 
    else {
      return new KeyboardInput();
    }
  }
}
