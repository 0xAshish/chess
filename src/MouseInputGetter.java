import javax.swing.SwingWorker;


public class MouseInputGetter extends SwingWorker<int[], Object> {
  
  private Screen _screen;
  static private int[] _move;
  static private int _s;
  static private int firstX, firstY;
  private int x, y;
  private int[] click;
  
  public MouseInputGetter(Screen screen) {
    _screen = screen;
    _move = new int[4];
    _s = 0;
  }
  
  @Override
  protected int[] doInBackground() throws Exception {
    while (!isCancelled()) {
      Thread.currentThread().sleep(100);
      click = _screen.getLastClickPos();
      x =  (int) (click[0]/Cell.SIZE);
      y =  (int) (click[1]/Cell.SIZE);
      if (click[0] != -1 && click[1] != -1) {
        _move[0 + 2*_s] = x;
        _move[1 + 2*_s] = y;
        firstX = x;
        firstY = y;
        
        _s += 1;
        if (_s == 2) {
          _screen.removeSelector();
          return _move;
        }
        else if (_s == 1) { 
          _screen.addSelector(x, y);
        }
      }
    }
    return null;
  }
  
}
