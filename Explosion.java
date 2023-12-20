package GameArcade;


import java.awt . Color;

public class PesawatUser extends Pesawat{
    private long elapsed;
    private long fireInterval  = 100;

    public PesawatUser(float x, float y, float dx, float dy,int width,int height,int orientation,Color color) {
        super(x,y,dx,dy,width,height,orientation,color);
}

    public void fireBullet(){
        if( elapsed >= fireInterfal){
            elapsed = 0;
            if(orientation == SOUTH){
            spawns.add(new Bullet(x,y,0f,-0.15f,6,15,SOUTH,Color.CYAN,this));
            spawns.add(new Bullet(x+width-3f,y,0f,-0.15f,6,15,SOUTH,Color.CYAN,this));
            }else{
            spawns.add(new Bullet(x,y,0f,0.2f,6,15,NORTH,Color.CYAN,this));
            spawns.add(new Bullet(x+width-3f,y,0f,0.15f,6,15,SOUTH,Color.CYAN,this));
            }
        }
    }
    public void update(long elapsedTime) {
    Super.update(elapsedTime);
    elapsed +=elapsedTime;
    }
}