package object.gameobjects.paint.impl;

import java.awt.Color;
import java.awt.Graphics;

import object.gameobjects.AGameObject;
import object.gameobjects.paint.IPaintStrategy;

public class BasicPaint implements IPaintStrategy{

	@Override
	public void init(AGameObject context) {		
	}

	@Override
	public void paint(Graphics g, AGameObject context) {
		g.setColor(Color.WHITE);
		g.fillRect(context.getPosition().x - context.getWidth() / 2,
				context.getPosition().y - context.getHeight() / 2,
				context.getWidth(), context.getHeight());
		g.setColor(Color.RED);
		g.drawLine(context.getPosition().x, context.getPosition().y,
				context.getPosition().x, context.getPosition().y);
	}

}
