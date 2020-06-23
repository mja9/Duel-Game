package object.sprites.paint.impl;

import java.awt.Color;
import java.awt.Graphics;

import object.sprites.AObject;
import object.sprites.paint.IPaintStrategy;

public class BasicPaint implements IPaintStrategy{

	@Override
	public void init(AObject context) {		
	}

	@Override
	public void paint(Graphics g, AObject context) {
		g.setColor(Color.WHITE);
		g.fillRect(context.getPosition().x - context.getWidth() / 2,
				context.getPosition().y - context.getHeight() / 2,
				context.getWidth(), context.getHeight());
		g.setColor(Color.RED);
		g.drawLine(context.getPosition().x, context.getPosition().y,
				context.getPosition().x, context.getPosition().y);
	}

}
