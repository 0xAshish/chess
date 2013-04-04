
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class Game {
  private Output _output;
  private Board _board;
  private Input _input;
  private int _turn;
  private int _interfaceType;

  public Game(int interfaceType) throws IOException {
    
    _interfaceType = interfaceType;
    
    //sets up output with either graphics or ascii
    OutputConstructor oc = new OutputConstructor();
    _output = oc.constructOutput(_interfaceType);
    Screen screen = _output.getScreen();
    
    //sets up board and pieces
    _board = new Board();
    
    //sets up user input with either mouse or keyboard
    InputConstructor ic = new InputConstructor();
    _input = ic.constructInput(_interfaceType);
    _input.setScreen(screen);
    
    // white goes first
    _turn = Piece.WHITE;
  }

  //Plays one game of chess.
  public void play() throws InterruptedException, ExecutionException {

    boolean gameOver = false;
    int[] move;
    
    while (gameOver == false) {
      // if it is someone's turn and they
      // can checkmate, they win.
      gameOver = _board.canWin(_turn);
      if (gameOver) {
        break;
      }
      
      // show board
      _output.displayBoard(_board);
      
      // get move, check if it is valid. if not valid ask again.
      // if it is valid then do the move.
      move = _input.getMove();
      if (_board.validMove(move[0], move[1], move[2], move[3], _turn) == false) {
        _output.invalidMove();
        continue;
      }
      _board.doMove(move);
      
      toggleTurn();
    }
    
    _output.displayWinner(_turn);
    
  }
  
  public void toggleTurn() {
    
    if (_turn == Piece.BLACK) {
      _turn = Piece.WHITE;
    }
    else {
      _turn = Piece.BLACK;
    }
  }
  
  public boolean playAgain() {
    return _input.playAgain();
  }
  
}
