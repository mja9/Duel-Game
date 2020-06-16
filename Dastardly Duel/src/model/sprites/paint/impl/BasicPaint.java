package model.sprites.paint.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.paint.IPaintStrategy;

public class BasicPaint implements IPaintStrategy{

	@Override
	public void init(ASprite context) {		
	}

	@Override
	public void paint(Graphics g, ASprite context) {
		g.setColor(Color.WHITE);
		g.fillRect(context.getPosition().x - context.getWidth() / 2,
				context.getPosition().y - context.getHeight() / 2,
				context.getWidth(), context.getHeight());
		g.setColor(Color.RED);
		g.drawLine(context.getPosition().x, context.getPosition().y,
				context.getPosition().x, context.getPosition().y);
	}

}
