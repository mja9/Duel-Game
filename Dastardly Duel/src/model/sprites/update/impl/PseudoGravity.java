package model.sprites.update.impl;

import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.update.IUpdateStrategy;

public class PseudoGravity implements IUpdateStrategy {

	private int _acceleration = 1;
	
	@Override
	public void init() {
		
	}

	@Override
	public void updateState(ASprite context) {
		context.setSpeed(new Point(context.getSpeed().x, 
				context.getSpeed().y < 20 ? context.getSpeed().y + _acceleration : context.getSpeed().y));
	}

}
