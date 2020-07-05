package object.gameobjects.movement.impl;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.paint.impl.ImagePaint;

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
		_context.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rightrun.gif", 0.65, 0.75));
	}

	@Override
	public void moveRight() {	
		_context.setSpeed(new Point(5, _context.getSpeed().y));
		_context.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rightrun.gif", 0.65, 0.75));
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
		_context.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rockmancropped.png", 0.57, 0.98));
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
