package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Map extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x=400,y=10,width=4,height=20;
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		for(int i = 0; i<15; i++) {
			g.fillRect(x, y + (i*40), width, height);			
		}
		
		
	}
}
