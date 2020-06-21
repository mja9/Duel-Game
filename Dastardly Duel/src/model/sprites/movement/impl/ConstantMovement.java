package model.sprites.movement.impl;

import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.movement.IMovementStrategy;

public class ConstantMovement implements IMovementStrategy {
	
	private ASprite _context;

	@Override
	public void init(ASprite context) {
		_context = context;
		_context.setSpeed(new Point(10, 0));
	}

	@Override
	public void move() {
		_context.setPosition(new Point(_context.getPosition().x + _context.getSpeed().x, 
				_context.getPosition().y + _context.getSpeed().y));
	}

}
