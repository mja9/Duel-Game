package object.gameobjects.action;

import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.sessile.RockWall;
import util.factory.IFactory;

public class Block implements IActionStrategy {

	private AGameObject _context;
	
	private IFactory<RockWall> _wallFactory;
	
	@Override
	public void init(AGameObject context) {
		_context = context;
		buildFactory();
	}
	
	private void buildFactory() {
		_wallFactory = new IFactory<RockWall>() {

			@Override
			public RockWall make(Object... parameters) {
				
				Point pos = new Point(_context.getSpeed().x >= 0 ?
						_context.getPosition().x + _context.getWidth() : 
							_context.getPosition().x - _context.getWidth(), _context.getPosition().y + _context.getHeight() / 2);
				
				return new RockWall(pos, _context.getAdapter());
			}
			
		};
	}

	@Override
	public void performAction() {
		_context.getAdapter().addObserver(_wallFactory.make());
	}

}
