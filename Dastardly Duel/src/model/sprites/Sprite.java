package model.sprites;

import java.awt.Graphics;

import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

public class Sprite {
	
	IPaintStrategy _paintStrategy;
	
	IMovementStrategy _movementStrategy;
	
	IActionStrategy _actionStrategy;
	
	IUpdateStrategy _updateStrategy;
	
	
	public Sprite(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy,
			IActionStrategy actionStrategy, IUpdateStrategy updateStrategy) {
		
		_paintStrategy = paintStrategy;
		_movementStrategy = movementStrategy;
		_actionStrategy = actionStrategy;
		_updateStrategy = updateStrategy;
		
	}
	
	public void update(Graphics g) {
		
		_movementStrategy.move();
		_paintStrategy.paint();
		_updateStrategy.updateState();
		
	}
	
	
	

}
