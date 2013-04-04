import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsOutput extends Output {
  
  private Screen _screen;
  private JFrame f;
  
  public GraphicsOutput() throws IOException {
    // Sets up the screen
    f = new JFrame();
    f.setSize(Cell.SIZE*Board.SIZE+16, Cell.SIZE*Board.SIZE+38);
    f.setTitle("A Fascinating Game of Chess, Indeed.");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    _screen = new Screen();

    f.setContentPane(_screen);
    f.setLayout(new BoxLayout(_screen, BoxLayout.PAGE_AXIS));
    f.setVisible(true);
  }
  
  @Override
  public void displayBoard(Board chessBoard) {
    // modify _screen for chessBoard and repaint() _screen
    _screen.setBoard(chessBoard);
    _screen.repaint();
  }

  @Override
  public void invalidMove() {
    // do nothing
  }

  @Override
  public void displayWinner(int color) {
    _screen.displayGameOver();
    _screen.repaint();
  }

  @Override
  public Screen getScreen() {
    return _screen;
  }

}
