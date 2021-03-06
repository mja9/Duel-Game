package object.gameobjects.movement.impl;

import java.awt.Point;

import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.movement.IMoveableStrategy;

public class InAirMoveable implements IMoveableStrategy {
	
	private ManualObject _context;

	@Override
	public void init(ManualObject context) {
		_context = context;
	}

	@Override
	public Point getPoint() {
		return _context.getPosition();
	}

	@Override
	public void moveLeft() {	
		_context.setSpeed(new Point(-5, _context.getSpeed().y));
	}

	@Override
	public void moveRight() {	
		_context.setSpeed(new Point(5, _context.getSpeed().y));
	}

	@Override
	public void moveUp() {		
	}

	@Override
	public void moveDown() {		
	}

	@Override
	public void stop() {
		_context.setSpeed(new Point(0, _context.getSpeed().y));
	}

	@Override
	public void act1() {
		_context.performPrimaryAction();
	}

	@Override
	public void act2() {
	}

}
