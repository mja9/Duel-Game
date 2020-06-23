package object.gameobjects.movement.impl;

import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.movement.IMovementStrategy;

public class BasicMovement implements IMovementStrategy {

	private AGameObject _context;

	@Override
	public void init(AGameObject context) {
		_context = context;
	}

	@Override
	public void move() {
		_context.setPosition(new Point(_context.getPosition().x + _context.getSpeed().x, 
				_context.getPosition().y + _context.getSpeed().y));
	}

}
