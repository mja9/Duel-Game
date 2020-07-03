package object.gameobjects.movement.impl;

import java.awt.Point;

import javax.swing.Timer;

import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.movement.IMoveableStrategy;

public class BasicMoveable implements IMoveableStrategy {
	
	private ManualObject _context;
	
	private int _currentState = 1;
	
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
		if (_currentState == 1) {
			groundState();
			changeState();
		} else {
			airState();
		}
	}
	
	private void groundState() {
		_context.setSpeed(new Point(_context.getSpeed().x, -20));

	}

	private void airState() {
	}
	
	public void changeState() {
		_currentState = -_currentState;
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
