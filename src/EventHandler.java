import java.awt.event.KeyEvent;
import java.util.ArrayList;

class EventHandler {


  public static void handle(ArrayList<KeyEvent> events){
      for(KeyEvent e : events){
          if(e.getKeyCode() == KeyEvent.VK_UP)
            System.out.print("Event handeed");



      }
  }

}
