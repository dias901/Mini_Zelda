package coisa;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{

	public boolean right,left,up,down;
	public int spd = 4;
	public int animationdown=0, animationup=0,animationright=0,animationleft=0;
	public int curframeup =0, targetFramesup = 10;
	public int curframedown =0, targetFramesdown = 10;
	public int curframeright =0, targetFramesright = 10;
	public int curframeleft =0, targetFramesleft = 10;
	public int agr =0;
	public static List<Bullets>bullets = new ArrayList<Bullets>();
	public boolean tiro =false;
	public int dir= 1;
	
	public Player(int x, int y) {
		super(90,90,32,32);//posição e dimensão do player
		
	}
	
		
	public void tick() {
		boolean movedown=false,moveup=false,moveright=false,moveleft = false;
		
		if(right && World.isfree(x+spd, y)) {
			x+=spd;
			moveright = true;
			dir=1;
		}else if(left && World.isfree(x-spd, y)){
			x-=spd;
			moveleft=true;
			dir=-1;
		}
		if(up && World.isfree(x, y-spd)) {
			y-=spd;
			moveup=true;
			dir=-1;
		}else if(down && World.isfree(x, y+spd)){
			y+=spd;
			movedown=true;
			dir=1;
		}
	if(movedown) {	
		curframedown++;
		agr = 2;
		if(curframedown == targetFramesdown) {
			curframedown=0;
			animationdown++;
			if(animationdown==Spritesheet.jogador_Down.length) {
				animationdown=0;
			}
		}
	}
	if(moveup) {	
		curframeup++;
		agr = 1;
		if(curframeup == targetFramesup) {
			curframeup=0;
			animationup++;
			if(animationup==Spritesheet.jogador_Up.length) {
				animationup=0;
			}
		}
	}
	if(moveright) {	
		curframeright++;
		agr=3;
		if(curframeright == targetFramesright) {
			curframeright=0;
			animationright++;
			if(animationright==Spritesheet.jogador_Right.length) {
				animationright=0;
			}
		}
	}
	if(moveleft) {	
		curframeleft++;
		agr = 4;
		if(curframeleft == targetFramesleft) {
			curframeleft=0;
			animationleft++;
			if(animationleft==Spritesheet.jogador_Left.length) {
				animationleft=0;
			}
		}
	}
	
	if(tiro) {
		tiro = false; //pra ele n atirar pra sempre
		bullets.add(new Bullets(x,y,dir));
	}
	
	for(int i =0;i<bullets.size();i++) {
		bullets.get(i).tick();
		
	}
	
}
	
	public void render(Graphics g) {
		if(agr==2) {
		g.drawImage(Spritesheet.jogador_Down[animationdown],x,y,32,32,null);
		}
		if(agr==1) {
			g.drawImage(Spritesheet.jogador_Up[animationup],x,y,32,32,null);
		}
		if(agr==3) {
			g.drawImage(Spritesheet.jogador_Right[animationright],x,y,32,32,null);
		}
		if(agr==4) {
			g.drawImage(Spritesheet.jogador_Left[animationleft],x,y,32,32,null);
		}
		for(int i =0;i<bullets.size();i++) {
			bullets.get(i).render(g);
			
		}
	}
}

//Rectangle tem todas box de colisão e vetores que precisamos