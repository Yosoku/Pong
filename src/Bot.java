class Bot extends Paddle{
  private Ball ball;
  private int speed;

  Bot(int x,int y,int w,int h,Ball b){
    super(x,y,w,h);
    ball = b;
    this.speed = 0;
  }




@Override
void update(){
  if(this.yPos < 0 )
    this.yPos = 0;
  if(this.yPos + this.height >=  Pong.HEIGHT)
    this.yPos = Pong.HEIGHT  -20- this.height;


  if(ball.getY() > this.yPos + this.height/2)
    this.speed +=1;
  else
    this.speed-=1;

  if(this.speed > MAX_SPEED)
    this.speed = MAX_SPEED;
  else if (this.speed < -MAX_SPEED)
    this.speed = -MAX_SPEED;

  this.yPos +=this.speed;



}

}
