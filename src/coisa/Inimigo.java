package coisa;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
	
	public class Inimigo extends Rectangle{
		public int right =1,left =0,down=0,up=0;
		public int spd = 2;
		public int dir= 1;
		
		public Inimigo(int x, int y) {
			super(90,90,32,32);
		}
		
		public void perseguirJogador(){
			Player p = Game.player;
			if(x<p.x && World.isfree(x+spd, y)) {
				if(new Random().nextInt(100)<50)
				x+=spd;
			}else if(x>p.x && World.isfree(x-spd, y)) {
				if(new Random().nextInt(100)<50)
				x-=spd;
			}
			
			if(y<p.y && World.isfree(x, y+spd)) {
				if(new Random().nextInt(100)<50)
				y+=spd;
			}else if(y>p.y && World.isfree(x, y-spd)) {
				if(new Random().nextInt(100)<50) //ele pega um numero aleatorio de 0-100 e se for menor que 50 ele se mexe
				y-=spd;
			}
		}
		
		public void tick() {
			perseguirJogador();
		}
		
		public void render(Graphics g) {
			g.drawImage(Spritesheet.Inimigo1[0],x,y,32,32,null);
		}
}

	//Rectangle tem todas box de colisão e vetores que precisamos
	//só pode pegar a posição do jogador se estiver static
