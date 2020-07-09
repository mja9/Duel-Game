package object.gameobjects.action;

import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.vagile.auto.Boulder;
import util.factory.IFactory;

public class BoulderAttack implements IActionStrategy {
	
	private final int projectileSpeed = 15;
	private AGameObject _context;
	private IFactory<Boulder> _boulderFactory;

	@Override
	public void init(AGameObject context) {		
		_context = context;
		buildFactory();
	}
	
	private void buildFactory() {
		_boulderFactory = new IFactory<Boulder>() {

			@Override
			public Boulder make(Object... parameters) {
				
				Point pos = new Point(_context.getSpeed().x < 0 ? _context.getPosition().x - _context.getWidth() / 2 - 15 :
					_context.getPosition().x + _context.getWidth() / 2 + 15, _context.getPosition().y - _context.getHeight() / 4);
				
				Boulder product = new Boulder(pos, _context.getAdapter());
				
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
