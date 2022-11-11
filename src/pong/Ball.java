package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void update(){
		
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(400, 315, 10, 10);
	}
}
