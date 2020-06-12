package model.sprites;

import java.awt.Point;

import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

public class Player extends Sprite {

	public Player(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy, IActionStrategy actionStrategy,
			IUpdateStrategy updateStrategy, Point pos) {
		super(paintStrategy, movementStrategy, actionStrategy, updateStrategy, pos);
	}
	
	

}
