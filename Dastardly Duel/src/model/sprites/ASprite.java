package model.sprites;

import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

public abstract class ASprite {
	
	IPaintStrategy _paintStrategy;
	
	IMovementStrategy _movementStrategy;
	
	IActionStrategy _actionStrategy;
	
	IUpdateStrategy _updateStrategy;
	
	
	public ASprite(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy,
			IActionStrategy actionStrategy, IUpdateStrategy updateStrategy) {
		
		_paintStrategy = paintStrategy;
		_movementStrategy = movementStrategy;
		_actionStrategy = actionStrategy;
		_updateStrategy = updateStrategy;
		
	}
	
	
	

}
