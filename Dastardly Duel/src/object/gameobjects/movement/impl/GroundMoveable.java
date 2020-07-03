package object.gameobjects.movement.impl;

import java.awt.Point;

import javax.swing.Timer;

import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import object.gameobjects.movement.IMoveableStrategy;

public class GroundMoveable implements IMoveableStrategy {
	
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
		_context.setSpeed(new Point(_context.getSpeed().x, -20));
		((Player) _context).changeState("air");
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
		_context.performSecondaryAction();
	}

}
