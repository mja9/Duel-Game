package object.gameobjects.movement.impl;

import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.movement.IMovementStrategy;

public class ConstantMovement implements IMovementStrategy {
	
	private AGameObject _context;

	@Override
	public void init(AGameObject context) {
		_context = context;
		_context.setSpeed(new Point(10, 0));
	}

	@Override
	public void move() {
		_context.setPosition(new Point(_context.getPosition().x + _context.getSpeed().x, 
				_context.getPosition().y + _context.getSpeed().y));
	}

}
