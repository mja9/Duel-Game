package object.gameobjects.movement.impl;

import java.awt.Point;

import javax.swing.Timer;

import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.movement.IMoveableStrategy;

public class BasicMoveable implements IMoveableStrategy {
	
	private ManualObject _context;
	
	private int jumpStatus = 0;
	
	private int jumpCoolDown = 1250;
	
	Timer _coolDownTimer = new Timer(jumpCoolDown, (e) -> resetJumpStatus());

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
		
		if (jumpStatus == 0) {
			_context.setSpeed(new Point(_context.getSpeed().x, -20));
			jumpStatus++;
			_coolDownTimer.start();
		}
		
	}
	
	private void resetJumpStatus() {
		jumpStatus = 0;
		_coolDownTimer.stop();
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
