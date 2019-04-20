import javax.swing.JFrame;
import java.awt.Dimension;
class Window extends JFrame{

    Window(int w,int h,String title,Pong comp){
      this.setPreferredSize(new Dimension(w,h));
      this.setTitle(title);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.add(comp);
      this.pack();
      this.setLocationRelativeTo(null);
      this.setResizable(false);
      this.setVisible(true);
      comp.start();
    }
}
