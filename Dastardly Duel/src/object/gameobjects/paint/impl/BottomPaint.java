package object.gameobjects.paint.impl;

import java.awt.Color;
import java.awt.Graphics;

import object.gameobjects.AGameObject;
import object.gameobjects.paint.IPaintStrategy;

public class BottomPaint implements IPaintStrategy {
	
	@Override
	public void init(AGameObject context) {		
	}

	@Override
	public void paint(Graphics g, AGameObject context) {
		g.setColor(Color.ORANGE);
		g.fillRect(context.getPosition().x - context.getWidth() / 2, 
				context.getPosition().y - context.getHeight(), context.getWidth(), context.getHeight());
	}

}
