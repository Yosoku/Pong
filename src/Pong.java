import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Font;

class Pong extends Canvas implements Runnable {
  public static final int WIDTH = 1200;
  public static final int HEIGHT = 900;

  private boolean running = false;
  private Thread thread;

  private Ball ball;
  private Paddle pad1;
  private Bot pad2;
  private int point1, point2;
  private KeyInput listener;

  public synchronized void start() {
    if (running)
      return;

    running = true;
    thread = new Thread(this);
    thread.start();
  }

  private synchronized void stop() {
    if (!running)
      return;

    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void init() {
    pad1 = new Paddle(30, 450, 20, 110);
    point1 = 0;

    ball = new Ball(WIDTH / 2, HEIGHT / 2, 0, 0);
    pad2 = new Bot(WIDTH - 2 * 30, 450, 20, 110, ball);
    point2 = 0;
    ball.start();
    listener = new KeyInput(pad1);
    this.addKeyListener(listener);

  }

  public void run() {
    init();
    this.requestFocus();
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int updates = 0;
    int frames = 0;
    while (running) {
      long now = System.nanoTime();
      delta = delta + (now - lastTime) / ns;
      lastTime = now;
      while (delta >= 1) {
        update();
        updates++;
        delta--;
      }
      render();
      frames++;

      if (System.currentTimeMillis() - timer > 1000) {
        timer = timer + 1000;
        //	System.out.println("FPS: " + frames + " "+ "Ticks: " + updates);
        frames = 0;
        updates = 0;
      }

    }
    stop();
  }

  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      this.createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();
    ////////////
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());
    //	controller.render(g);														//Modify only the part between comments
    pad1.render(g);
    pad2.render(g);
    ball.render(g);
    g.setFont(new Font("Aerial", Font.PLAIN, 18));
    g.drawString("Player 1 : " + point1, 10, 30);
    g.drawString("Player 2 : " + point2, WIDTH - 100, 30);
    ////////////
    g.dispose();
    bs.show();

  }

  private void update() {
    pad1.update();
    pad2.update();
    ball.update();

    if (collide())
      ball.reverseXspeed();
    if (pointScored()) {

      restartGame();
      try {
        thread.sleep(100);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  private void log(String mes) {
    System.out.println(mes);
  }

  private void restartGame() {
    log("restart called");
    pad1.reset();
    pad2.reset();
    ball.reset();
  }

  public boolean collide() {
    if (ball.getX() <= pad1.getX() + pad1.getWidth() - 1 && ball.getY() >= pad1.getY()
        && ball.getY() <= pad1.getY() + pad1.getHeight() - 1) {
      System.out.print("pad1 collide");
      return true; //pad1
    } else if (ball.getX() == pad2.getX() && ball.getY() >= pad2.getY()
        && ball.getY() <= pad2.getY() + pad2.getHeight() - 1) {
      System.out.print("pad2 collide");
      return true; //pad2
    }
    return false;

  }

  private boolean pointScored() {

    if (ball.getX() <= 0) {
      log("Ballx :" + ball.getX() + " Bally :" + ball.getY());
      point2++;
      return true;
    }
    if (ball.getX() >= Pong.WIDTH) {
      log("Ballx :" + ball.getX() + " Bally :" + ball.getY());
      point1++;
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Window win = new Window(Pong.WIDTH, Pong.HEIGHT, "dicks", new Pong());

  }
}
