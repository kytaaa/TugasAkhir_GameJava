package GameArcade;

import java.awt.Graphics;


public abstract class GameObject{
	
	public static final int LIFE  = 1;
	public static final int DEATH = 2;
	
	public static final int SOUTH = 1;
	public static final int NORTH = 2;
	
	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;
	
	protected int orientantion;
	protected int width;
	protected int height;
	
	protected int state;
	
	public GameObject() {
		state = LIFE;
	}
	
	public GameObject(float x,float y,float dx,float dy,int width, int height,int orientation) {
		this ();
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=y;
		this.width=width;
		this.height=height;
		this.orientantion = orientation;
	}

	public abstract void update (long elasedTime);
	
	public abstract void draw(Graphics g);
	
	public Rectangle getBound() {
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	public boolean isCollodedWith(GameObject object) {
		return getBound().interesect(object.getBound());
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getDX() {
		return dx;
	}
	
	public void setDX(float dx) {
		this.dx = dx;
	}
	
	public float getDY() {
		return dy;
	}
	
	public void setDY(float dy) {
		this.dy = dy;
	}
	
	public int getOrientation() {
		return orientation;
	}
	
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}