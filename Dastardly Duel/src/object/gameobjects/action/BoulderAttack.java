package object.gameobjects.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.vagile.auto.Boulder;
import object.gameobjects.movement.impl.ConstantMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class BoulderAttack implements IActionStrategy {
	
	private final int projectileSpeed = 25;
	private AGameObject _context;

	@Override
	public void init(AGameObject context) {		
		_context = context;
	}

	@Override
	public void performAction() {
		Boulder boulder = new Boulder(new Point(_context.getPosition().x + _context.getWidth() / 2 + 5, 
						_context.getPosition().y - _context.getHeight() / 4), 
				5, 5, new IPaintStrategy() {
					
					@Override
					public void init(AGameObject context) {
					}
		
					@Override
					public void paint(Graphics g, AGameObject context) {
						g.setColor(Color.YELLOW);
						g.fillOval(context.getPosition().x, context.getPosition().y, 
								context.getWidth(), context.getHeight());
					}
					
				}, _context.getAdapter(), IUpdateStrategy.NULL_UPDATE, new ConstantMovement());
		_context.getAdapter().addObserver(boulder);
		
	}

}
