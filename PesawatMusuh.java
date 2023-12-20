package GameArcade;

import java.awt.Color;

public class PesawatMusuh extends Pesawat{
    
        private long lastTimeFire;
        private long fireInterval = 1500;
        private Random random;
        public PesawatMusuh(float x, float dx, float dy, int width, int height, int orientation,Color color) {
            super(x,y,dx,dy,width,height,orientation,color);
            random = new Random();
            fireInterval = random.nextInt(1500)+500;
        }


    public void update(long elapsedTime) {
        super.update(elapsedTime);
        
        lastTimeFire += elapsedTime;
        if( lastTimeFire >= fireInterval){
            fireBullet();
            lastTimeFire = 0;
        }
    }
}
