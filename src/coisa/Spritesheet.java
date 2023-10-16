package coisa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

	public class Spritesheet {

	public static BufferedImage spritesheet;
	public static BufferedImage[] jogador_Down;
	public static BufferedImage[] jogador_Up;
	public static BufferedImage[] jogador_Right;
	public static BufferedImage[] jogador_Left;
	public static BufferedImage parede;
	public static BufferedImage Inimigo;
	public static BufferedImage[] Inimigo1;
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/Spritsheet.png"));
			parede = ImageIO.read(getClass().getResource("/Mundo.png"));
			Inimigo = ImageIO.read(getClass().getResource("/spritesheet2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Inimigo1 = new BufferedImage[1];
		
		jogador_Up = new BufferedImage[3];
		jogador_Up[0]= Spritesheet.getSprite(63,4,14,15);
		jogador_Up[1]= Spritesheet.getSprite(83,4,14,14);
		jogador_Up[2]= Spritesheet.getSprite(84,23,14,14);
		
		
		jogador_Right = new BufferedImage[2];
		jogador_Right[0]= Spritesheet.getSprite(23,22,13,16);
		jogador_Right[1]= Spritesheet.getSprite(63,23,12,16);		
		
		jogador_Left = new BufferedImage[2];
		jogador_Left[0]= Spritesheet.getSprite(3,22,13,16);
		jogador_Left[1]= Spritesheet.getSprite(42,23,13,15);		
		
		jogador_Down = new BufferedImage[3];
		jogador_Down[0]= Spritesheet.getSprite(3,3,14,16);
		jogador_Down[1]= Spritesheet.getSprite(22,4,14,15);
		jogador_Down[2]= Spritesheet.getSprite(42,4,14,15);
		
		parede = Spritesheet.getWall(8, 98, 8, 12);
		Inimigo1[0] = Spritesheet.getInimigo(1,11,15,16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		
	return spritesheet.getSubimage(x,y,width,height);
	}
	
	public static BufferedImage getWall(int x, int y, int width, int height) {
		return parede.getSubimage(x, y, width, height);
	}
	
	public static BufferedImage getInimigo(int x, int y, int width, int height) {
		
		return Inimigo.getSubimage(x,y,width,height);
		}
		
}
