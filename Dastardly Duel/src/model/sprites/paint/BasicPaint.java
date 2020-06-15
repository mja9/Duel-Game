package model.sprites.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class BasicPaint implements IPaintStrategy{

	@Override
	public void init() {		
	}

	@Override
	public void paint(Graphics g, Point p, int width, int height) {
		g.setColor(Color.WHITE);
		g.fillRect(p.x - width / 2, p.y - height / 2, width, height);
		g.setColor(Color.RED);
		g.drawLine(p.x, p.y, p.x, p.y);
	}

}
