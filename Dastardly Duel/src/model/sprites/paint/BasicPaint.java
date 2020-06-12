package model.sprites.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class BasicPaint implements IPaintStrategy{

	@Override
	public void init() {		
	}

	@Override
	public void paint(Graphics g, Point p) {
		g.setColor(Color.ORANGE);
		g.fillRect(p.x, p.y, 10, 10);
	}

}
