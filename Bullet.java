package GameArcade;

import java.awt.Color;

public class Bullet extends GameObject{
    private Pesawat owner;
    private Color color;
    
    public Bullet(){
        
    }
    
    public Bullet(float x, float y, float dx, float dy, int width, int height, int orientation, Color color, Pesawat owner){
        super(x,y,dx,dy,width,height,orientation);
        this.color =color;
        this.owner = owner;
    }
    
    public void draw(Graphics g) {
        int xPoints[] = new int[5];
        int yPoints[] = new int[5];
        
        if(orientation == SOUTH){
            xPoint[0] =(int) (x+(width/2f));
            xPoint[1] = xPoint[2] = (int) (x+width);
            xPoint[3] = xPoint[4] = (int)(x);
            
            yPoint[0] = (int)y;
            yPoint[1] = yPoint[4] = (int) (y+5);
            yPoint[2] = yPoint[3] = (int) (y+height);
        }else{
            xPoint[0] = (int) (x+(width/2f));
            xPoint[1] = xPoint[2] = (int)(x+width);
            xPoint[3] = xPoint[4] = (int)(x);
            
            yPoint[0] = (int)(y+height);
            yPoint[1] = yPoint[4] = (int)(y+(height-5));
            yPoint[2] = yPoint[3] =(int) (y);
        }
       g.setColor(color);
       g.fillPolygon(xPoints,yPoints,5);
       g.setColor(Color.black);
       g.drawPolygon(xPoints,yPoints,5);
    }
    
    public void update(long elapsedTime){
        x+=dx*elapsedTime;
        y+=dy*elapsedTime;
    }
    
    public pesawat getOwner(){
        return owner;
    }
    
    public void setOwner(Pesawat owner) {
        this.owner = owner;
    }
    
}

