package GameArcade;

import java.awt.Color;

public class Background {
	float speed = 0.0000001f;
	float vel1 = 1;
	float vel2 = 1;

	public void update(long elapsedTime){
	vel1+= speed*elapsedTime;
	vel2+= speed*elapsedTime;
	vel1%=50;
	vel2%=60;
}

public void draw(Graphics g) {
	g.setColor(new Color(164, 164, 164));
	g.fillRect(0, 0, 400, 400);
	g.setColor(new Color(128, 128, 128));
	g.fillRect(0, 0, 25, 400);
	g.fillRect(Color.white);

	int a = 0;
	for(int i=10;i<400;i+=25){
		a = (int) ((i+i)+vel1);
		g.fillRect(195, a, 5, 25);
	}

	for(int i=10;i<400;i+30){
	a =(int) ((i+i)+vel2);
	g.drawLine(0, a, 25, a);
	g.drawLine(375, a, 400, a);
}
}