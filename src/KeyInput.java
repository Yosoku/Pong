import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyInput extends KeyAdapter{
  private Paddle player;
  KeyInput(Paddle player){
    this.player = player;
  }
    public void keyPressed(KeyEvent e){
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_DOWN){
      player.moveDown();
      }
      if(key == KeyEvent.VK_UP)
      {
        player.moveUp();
      }

    }

    




}
