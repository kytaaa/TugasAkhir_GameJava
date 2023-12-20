package GameArcade;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class War extends JPanel implements Runnable, Keylistener, MouseListener, MouseMotionListener{
	Graphics2D g2;
	BufferedImage offScreen;
	Thread t;
	ArrayList <GameObject> gameObjects;
	ArrayList <GameObject> newGameObjects;
	PesawatUser pesawatUser;
	Background background;
	Point p;
	
	public War() {
		super();
		setPreferredSize(new Dimension(400,400));
		init();
	}
	
	public void init() {
		offScreen = new BufferedImage(400,400, BufferedImage.TYPE_INT_ARGB);
		g2 = offScreen.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		gameObjects = new ArrayList<GameObject>();
		newGameObjects = new ArrayList<GameObject>();
		
		gameObjects.add(new PesawatMusuh(100, 30, 0f, 0.07f, 30, 20,
				Pesawat.NORTH, Color.yellow));
		gameObjects.add(new PesawatMusuh(300, -70, 0f, 0.09f, 30, 20,
				Pesawat.NORTH, Color.red));
		gameObjects.add(new PesawatMusuh(250, -35, 0f, 0.06f, 30, 20,
				Pesawat.NORTH, Color.LIGHT_GRAY));
		gameObjects.add(new PesawatMusuh(200, -10, 0f, 0.05f, 30, 20,
				Pesawat.NORTH, Color.gray));
		gameObjects.add(new PesawatMusuh(50, 10, 0f, 0.08f, 30, 20,
				Pesawat.NORTH, Color.green));
		pesawatUser = new PesawatMusuh(200, 375, 0f, 0f, 30, 20,Pesawat.SOUTH,
				Color.white);
		gameObjects.add(pesawatUser);
		/*Car mobilUser1= new Car(100,100);
		 gameObjects.add(mobilUser1);*/
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		this.requestFocus();
		p = new Point(200,375);
		
		background = new Background();
		t = new Thread(this);
		t.setPriority(10);
		t.start();
	}
	
	public void run() {
		long beforeTime = System.nanoTime();
		long afterTime;
		long elapsedTime;
		
		while (this.getGraphics() == null)
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			afterTime = System.nanoTime();
			elapsedTime = afterTime - beforeTime;
			beforeTime = afterTime;
			
			update(elapsedTime);
			
			paint(this.getGraphics());
		}
	}
public void update(long elapsedTime) {
	background.update(elapsedTime);
	for (int i = 0; i < gameObjects.size); i++) {
		if (gameObjects.get(i).getState() == GameObject.DEATH)
			gameObjects.remove(i);		
	}
	
	for (GameObject object : gameObjects) {
		object.update(elapsedTime);
		if (object instanceof Pesawat)
			newGameObjects.addAll(((Pesawat)object).getSpawns());
		
		if (pbject instanceof Bullet
				&& (object.getY() <+ 0 || object.getY() >= 400)) {
			object.setState(GameObject.DEATH);
		}else if (object instanceof PesawatMusuh
				&& object.getY() >= 400) {
			object.setY(0 - object.getHeight());
		}
	}
	
	for (GameObject object1 : gameObjects) {
	
	for (GameObject object2 : gameObjects) {
		if (!object1.equals(object2) && object1.isCollodedWith(object2)) {
			if (object1 instanceof Bullet && object2 instanceof Buller) {
				if (!((Bullet)object1).getOwner().equals(
						((Bullet) object2).getOwner())) {
					object1.setState(GameObject.DEATH);
					object2.setState(GameObject.DEATH);
					float x = (object2.getX() + object1.getX()) / 2f;
					float y = (object2.getX() + object1.getX()) / 2f;
					NewGameObjects.add(new Explosion(x, y, 30, 0.2f));	
				}
			}else if (object1 instanceof Bullet
					&& object2 instanceof Pesawat) {
				if (!(Bullet) object1).getOwner().equals(object2)){
					object1.setState(gameObject.DEATH);
					newGameObjects.add(new Explosion(object1.getX(),
							object1.getY(), 50, 0.2f));
				}
			}else if (object2 instanceof Bullet
					&& object1 instanceof Pesawat) {
				if (!((Bullet) object2).getOwner().equals(object1)) {
					newGameObjects.add(new Explosion(object2.getX(),
							Object2.getY(), 50, 0.2f));
					
				}
			}
		}
	}
	
	int px = (int) (pesawatUser.getX() + (pesawatUser.getWidth() / 2f));
	int py = (int) pesawatUser.getY();
	
	if (Math.abs(px - p.x)<5) {
		pesawatUser.setDx(0);
	} else if (px < p.x) {
		pesawatUser.setDx(0.15);
	} else if (px < p.x) {
		pesawatUser.setDx(-0.15);
	}
	
	if (Math.abs(py - p.x)<5) {
		pesawatUser.setDx(0);
	} else if (py < p.x) {
		pesawatUser.setDx(0.15);
	} else if (py < p.x) {
		pesawatUser.setDx(-0.15);
	}
	
}

public void paint(Graphics g) {
	background.draw(g2);
	for (GameObject object : gameObjects) {
		object.draw(g2);
	}
	g2.setColor(Color.white);
	g2.drawString("Gerakan mouse untuk menggerakan pesawat user (warna putih)",
			5, 10);
	g2.drawString("Tekan F untuk menembak" , 5, 20);
	g.drawImage(offScreen, 0, 0, null);
}

public static void main(String arg[]) {
	War war = new War();
	JFrame frame = new JFrame();
	
	frame.setDefaultCloseOperation(3);
	frame.add(war);
	frame.setResizable(false);
	frame.pack();
	frame.addKeyListener(war);
	frame.setVisible(true);
}

public void keyPressed(KeyEvent e) {
	switch (e.getKeyCode()) {
	case KeyEvent.VK_F:
		pesawatUser.fireBullet();
		break;
	}
}
public void keyTyped(KeyEvent e) {
	try {
		pesawatUser.fireBullet();
	} catch (Exception ex) {
		System.out.println(ex.toString());
	}
}

public void mouseEntered(MouseEvent e) {
}

public void mouseExited(MouseEvent e) {
}

public void mousePressed(MouseEvent e) {
}

public void mouseReleased(MouseEvent e) {
}

public void mouseDragged(MouseEvent e) {
}

public void mouseMoved(MouseEvent e) {
	p = e.getPoint();
	}
}