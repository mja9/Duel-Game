package object.gameobjects.action;

import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.sessile.RockWall;

public class Block implements IActionStrategy {

	private AGameObject _context;
	
	@Override
	public void init(AGameObject context) {
		_context = context;
	}

	@Override
	public void performAction() {
		System.out.println("Reached here!\n");
		RockWall wall = new RockWall(new Point(_context.getSpeed().x >= 0 ?
				_context.getPosition().x + _context.getWidth(): 
					_context.getPosition().x - _context.getWidth(), _context.getPosition().y),
				_context.getAdapter());
		_context.getAdapter().addObserver(wall);
	}

}
