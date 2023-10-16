
package coisa;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

	public static int WIDTH = 480, HEIGHT = 480;
	public static Player player; //static pra conseguir acessar ele
	public static World world;
	public List<Inimigo>Inimigo=new ArrayList<Inimigo>(); //Nova forma de criar variável e instanciar
	
	public Game() {
		this.addKeyListener(this);//adicionar eventos de teclado e os metodos para cria esse evento ja foram criado
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		new Spritesheet();
		player = new Player(32,32);
		world = new World();
		for(int i=0; i<5;i++) {
		if(i<3) {
		Inimigo.add(new Inimigo(32,32));
			}
		}
	}
	
	public void tick() {
		player.tick();
		for(int i=0;i<Inimigo.size();i++) {
			Inimigo.get(i).tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;			
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,WIDTH, HEIGHT);
		
		player.render(g);
		world.render(g);
		for(int i=0;i<Inimigo.size();i++) {  //oq é isso?
			Inimigo.get(i).render(g);
		}
		
		bs.show();
	}
	
	public static void main (String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Zelda");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		new Thread(game).start();
	}

	@Override
	public void run() {
		requestFocus();
		
		while (true) {
			tick();
			render();
			
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			player.tiro = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}
	
}
//sempre buscar uma otimização e n deixar espaço na memoria sem motivo
//como esta rodando a 60fps a cada tick é 1 segundo
//a thread é do java e quando você cria ela e da o start ele
//procura pelo metodo na classe game (run)
//tick é responsavel pela logica do nosso jogo, colisoes,
//movimentação.