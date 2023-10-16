package coisa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullets extends Rectangle{
	
	public int dir = 1;
	public int speed = 8;
	public int timer = 0;

	public Bullets(int x, int y, int dir) {
		super(x,y,10,10);
		this.dir=dir;
	}
	
	public void tick() {
		x+=speed*dir;
		timer++;
		if(timer==40) { //durar menos de 1 seg(60fps)
			Player.bullets.remove(this);	
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height); //width e height vem da classe rectangle
	}
}
