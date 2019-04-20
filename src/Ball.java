import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
class Ball {
  private int xPos;
  private int yPos;
  private int xSpeed;
  private int ySpeed;
  private static final int SPEED = 10;



  Ball(int x,int y,int xs,int ys){
    this.xPos = x;
    this.yPos = y;
    this.xSpeed = xs;
    this.ySpeed = ys;
  }
  public int getX(){
    return this.xPos;
  }
  public int getY(){
    return this.yPos;
  }
  public void reset(){
    this.xPos = Pong.WIDTH/2;
    this.yPos = Pong.HEIGHT/2;
    start();
  }
  public void start(){
    Random r = new Random();
    this.xSpeed = r.nextInt(this.SPEED);
    this.ySpeed = r.nextInt(this.SPEED);
  }
  public void update(){
    if(this.yPos < 0 || this.yPos + 20 > Pong.HEIGHT)
      this.ySpeed *=-1;
    if(this.xPos > Pong.WIDTH)
      this.xSpeed*=-1;
    move();

  }

  public void reverseXspeed(){
    this.xSpeed*=-1;
  }
  private void move(){
    this.xPos +=this.xSpeed;
    this.yPos += this.ySpeed;
  }

  public void render(Graphics g){
    g.setColor(Color.WHITE);
    g.fillOval(this.xPos, this.yPos, 20, 20);
  }





}
