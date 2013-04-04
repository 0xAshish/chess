import java.io.IOException;


public class OutputConstructor {

  public Output constructOutput(int interfaceType) throws IOException {
    
    if (interfaceType == InputConstructor.GUI) {
      return new GraphicsOutput();
    }
    else {
      return new TextOutput();
    }
  }
  
}
