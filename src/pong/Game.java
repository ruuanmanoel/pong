package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
	

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 267;
	private static final int HEIGHT = 200;
	private static final int SCALE = 3;
	public boolean isRunning;
	
	public Thread thread;
	public JFrame frame;
	public BufferedImage layer;
	public Player player;
	public Player player2;
	public Ball ball;
	public Map map;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		this.addKeyListener(this);
		player = new Player(20,220);
		player2 = new Player(760,220);
		ball = new Ball();
		map = new Map();
	}
	public void initFrame() {
		frame = new JFrame("Pong");
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		layer = new BufferedImage(WIDTH*SCALE, HEIGHT*SCALE, BufferedImage.TYPE_INT_RGB);
	}
	
	public void update() {
		player.update();
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		g.clearRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		map.render(g);
		player.render(g);
		player2.render(g);
		ball.render(g);
	
		
		
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE,null);
		bs.show();
		
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();

	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning=true;
		thread.start();
		
	}
	
	@Override
	public void run() {
		while(isRunning) {
			update();
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player.down = true;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			player.up = true;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player.down = false;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			player.up = false;
		}
		
	}

}
