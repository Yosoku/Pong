import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyInput extends KeyAdapter {
  private Paddle player;

  KeyInput(Paddle player) {
    this.player = player;
  }

  // public void keyPressed(KeyEvent e) {
  //   int key = e.getKeyCode();
  //   if (key == KeyEvent.VK_DOWN) {
  //     player.moveDown();
  //   }
  //   if (key == KeyEvent.VK_UP) {
  //     player.moveUp();
  //   }
  //
  // }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_DOWN) {
      player.moveDown();
    }
    if (key == KeyEvent.VK_UP) {
      player.moveUp();
    }
  }

  public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_DOWN) {
      player.setSpeed(0);
    }
    if (key == KeyEvent.VK_UP) {
      player.setSpeed(0);
    }
  }
}
