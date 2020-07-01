package object.gameobjects.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.vagile.auto.AutoObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Kill;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.ConstantMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;
import util.factory.IFactory;

public class BoulderAttack implements IActionStrategy {
	
	private final int projectileSpeed = 25;
	private AGameObject _context;
	private IFactory<AutoObject> _boulderFactory;

	@Override
	public void init(AGameObject context) {		
		_context = context;
		buildFactory();
	}
	
	private void buildFactory() {
		_boulderFactory = new IFactory<AutoObject>() {

			@Override
			public AutoObject make(Object... parameters) {
				
				Point pos = new Point(_context.getPosition().x + _context.getWidth() / 2 + 5, 
						_context.getPosition().y - _context.getHeight() / 4);
				
				int width = 5;
				
				int height = 5;
				
				IPaintStrategy paintStrategy = new IPaintStrategy() {
					
					@Override
					public void init(AGameObject context) {
					}
		
					@Override
					public void paint(Graphics g, AGameObject context) {
						g.setColor(Color.YELLOW);
						g.fillOval(context.getPosition().x, context.getPosition().y, 
								context.getWidth(), context.getHeight());
					}
				};
				
				IInteractionStrategy interactStrategy = new Kill();
				
				IMovementStrategy movementStrategy = new ConstantMovement();
				
				AutoObject product = new AutoObject(pos, width, height, paintStrategy, _context.getAdapter(), 
						IUpdateStrategy.NULL_UPDATE, interactStrategy, movementStrategy);
				
				product.setSpeed(new Point(_context.getSpeed().x < 0 ? projectileSpeed * -1 : projectileSpeed * 1, 0));
				
				return product;
			}
			
		};
	}

	@Override
	public void performAction() {
		_context.getAdapter().addObserver(_boulderFactory.make());
		
	}

}
