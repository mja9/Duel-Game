package object.sprites.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import object.sprites.AObject;
import object.sprites.impl.interactive.vagile.auto.Boulder;
import object.sprites.movement.impl.ConstantMovement;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class BoulderAttack implements IActionStrategy {
	
	private final int projectileSpeed = 25;
	private AObject _context;

	@Override
	public void init(AObject context) {		
		_context = context;
	}

	@Override
	public void performAction() {
		Boulder boulder = new Boulder(new Point(_context.getPosition().x + _context.getWidth() / 2 + 5, 
						_context.getPosition().y - _context.getHeight() / 4), 
				5, 5, new IPaintStrategy() {
					
					@Override
					public void init(AObject context) {
					}
		
					@Override
					public void paint(Graphics g, AObject context) {
						g.setColor(Color.YELLOW);
						g.fillOval(context.getPosition().x, context.getPosition().y, 
								context.getWidth(), context.getHeight());
					}
					
				}, _context.getAdapter(), IUpdateStrategy.NULL_UPDATE, new ConstantMovement());
		
		
	}

}
