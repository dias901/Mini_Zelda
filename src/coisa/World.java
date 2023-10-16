package coisa;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class World{
	
	public static List<Blocks> blocos = new ArrayList<Blocks>();
	
	public World() {
		for (int a = 0; a < 15 ; a ++) {
			blocos.add(new Blocks(a*32,0));
		}
		for (int b = 0; b < 15 ; b ++) {
			blocos.add(new Blocks(0,b*32));
		}
		for (int c = 0; c < 15 ; c ++) {
			blocos.add(new Blocks(c*32,480-32));
		}
		for (int d = 0; d < 15 ; d ++) {
			blocos.add(new Blocks(480-32,d*32));
		}
		
		blocos.add(new Blocks(80,150));
	}
	public static boolean isfree(int x, int y) {
		for(int i=0;i<blocos.size();i++) {
			Blocks blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))){
				return false;
			}
		}
		return true;
	}
	public void render(Graphics g) {
		for(int i = 0; i < blocos.size(); i++ ) {
			blocos.get(i).render(g);
		}
	}
}
