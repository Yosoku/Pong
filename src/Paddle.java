import java.awt.Graphics;
import java.awt.Color;
class Paddle {
  private int xPos;
  private int yPos;
  private int speed;
  private int width;
  private int height;
  Paddle(int x,int y,int w,int h){
    this.xPos = x;
    this.yPos = y;
    this.width = w;
    this.height = h;
    this.speed = 50;
  }


public int getX(){
    return this.xPos;
  }
  public int getY(){
    return this.yPos;
  }
  public int getHeight(){
    return this.height;
  }
  public int getWidth(){
    return this.width;
  }

  void update(){
    if(this.yPos < 0 )
      this.yPos = 0;
    if(this.yPos + this.height >=  Pong.HEIGHT)
      this.yPos = Pong.HEIGHT  -20- this.height;

  }


  public void reset(){
    this.yPos = Pong.HEIGHT/2;
  }
  /**
    Positive speed means move down,negative means move up
  */
  void moveUp(){
    this.yPos  = this.yPos - this.speed;
  }
  void moveDown(){
    this.yPos  = this.yPos + this.speed;
  }

  void render(Graphics g){
    g.setColor(Color.WHITE);
    g.fillRect(this.xPos, this.yPos, this.width,this.height);//, height);
  }



}
