import java.awt.Graphics;
import java.awt.Color;

class Paddle {
  protected int xPos;
  protected int yPos;
  protected int speed;
  protected int width;
  protected int height;
  protected final int MAX_SPEED =15;

  Paddle(int x, int y, int w, int h) {
    this.xPos = x;
    this.yPos = y;
    this.width = w;
    this.height = h;
    this.speed = 0;
  }

  public int getX() {
    return this.xPos;
  }

  public int getY() {
    return this.yPos;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  void update() {
    if (this.speed > MAX_SPEED)
      this.speed = MAX_SPEED;
      else if(this.speed < -MAX_SPEED)
        this.speed = -MAX_SPEED;
    this.yPos += this.speed;
    if (this.yPos < 0)
      this.yPos = 0;
    if (this.yPos + this.height >= Pong.HEIGHT)
      this.yPos = Pong.HEIGHT - 20 - this.height;

  }

  public void reset() {
    this.yPos = Pong.HEIGHT / 2;
  }

  /**
    Positive speed means move down,negative means move up
  */
  void moveUp() {
    this.speed -= 5;
    //    this.yPos  = this.yPos - this.speed;
  }

  void moveDown() {
    this.speed += 5;
    //this.yPos  = this.yPos + this.speed;
  }

  void render(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(this.xPos, this.yPos, this.width, this.height);
  }

}
