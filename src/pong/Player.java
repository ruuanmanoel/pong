package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Canvas {
	private static final long serialVersionUID = 1L;
	private int x, y;
	public boolean	up, down;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		if(down) {
			y++;
		}else if(up) {
			y--;
		}
	}
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 10, 150);
	}
}
