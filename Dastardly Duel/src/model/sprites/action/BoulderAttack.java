package model.sprites.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.impl.projectiles.Boulder;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

public class BoulderAttack implements IActionStrategy {
	
	private final int projectileSpeed = 25;
	private ASprite _context;

	@Override
	public void init(ASprite context) {		
		_context = context;
	}

	@Override
	public void performAction() {
		Boulder boulder = new Boulder(new IPaintStrategy() {
			
			@Override
			public void init(ASprite context) {
			}

			@Override
			public void paint(Graphics g, ASprite context) {
				g.setColor(Color.YELLOW);
				g.fillOval(context.getPosition().x, context.getPosition().y, 
						context.getWidth(), context.getHeight());
			}
			
		}, 
				IMovementStrategy.NULL_MOVEMENT, IActionStrategy.NULL_ACTION, 
				IUpdateStrategy.NULL_UPDATE, 
				new Point(_context.getPosition().x + _context.getWidth() / 2 + 5, 
						_context.getPosition().y - _context.getHeight() / 4), 
				_context.getScreenSize(), 5, 5, _context.getCanvas());
		
		
	}

}
