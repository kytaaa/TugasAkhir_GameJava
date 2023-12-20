package GameArcade;

import java.awt.Color;

public class Pesawat extends GameObject{

protected Color color;
ArrayList<GameObject>spawns;

public Pesawat(){
widht = 10;
height = 7;
orientation = SOUTH;
}

public Pesawat(float x, float y, float dx, float dy,int width,int height, int orientation,Color color){
super(x,y,dx,dy,width,height,orientation);
this.color = color;
spawns = new ArrayList<GameObject>();
}

@Override
public void draw(Graphics g){
// TODO Auto-generated method stub
int xPoints[] = new int[3];
int yPoints[] = new int[3];

if(orientation == SOUTH){
xPoints[0] = (int)(x+(width/2.0));
xPoints[1] = (int)(x+width);
xPoints[2] = (int)x;

yPoints[0] = (int)y;
yPoints[1] = yPoints[2] = (int)(y+height);
}else{
xPoints[0] = (int)(x+(width/2.0));
xPoints[1] = (int)(x+width);
xPoints[2] = (int)x;

yPoints[0] = (int)(y+height);
yPoints[1] = yPoints[2] = (int)(y);
}
g.setColor(color);
g.fillPolygon(xPoints, yPoints, 3);
g.setColor(Color.black);
g.drawPolygon(xPoints, yPoints, 3);
}

public void update(long elapsedTime){
x+=dx*elapsedTime;
y+=dy*elapsedTime;
}

public void fireBullet(){
if(orientation == SOUTH){
spawns.add(new Bullet(x+width/2f-3f,y,0f,0,15f,6,15,SOUTH,Color.orange,this));
}else{
spawmss.add(new Bullet(x+width/2f-3f,y+height,0f,0.2f,6,15,NORTH,Color.orange,this));
}
}

public ArrayList<GameObject> getSpawns(){
ArrayList<GameObject> spawnsClone = (ArrayList<GameObject>) spawns.clone();
spawns.clear();
return spawnsClone;
}

public int getOrientation(){
return orientation;
}

public void setOrientation(int orientation){
this.orientation = orientation;
}

public int getWidth(){
return width;
}

public void setWidth(int width){
this.width = width;
}

public int getHeight(){
return height;
}

public void setHeight(int height){
this.height = height;
}

public Color getColor(){
return color;
}

public void setColor(Color color){
this.color = color;
}

public Rectangle getBound(){
return new Rectangle((int)x+5,(int)y+5,width-5,height-5);


}
}
