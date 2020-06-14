package model.sprites;

import java.awt.Dimension;
import java.awt.Point;

import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMoveableKeys;
import model.sprites.movement.IMoveableStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

/**
 * A sprite defined by its ability to be controlled by the gamer.
 * @author miguelarana
 *
 */
public class Player extends Sprite {
	
	private IMoveableStrategy _moveableStrategy = IMoveableStrategy.NULL_MOVEABLE;
	
	private IMoveableKeys _moveableKeys = IMoveableKeys.STANDARD_KEYS;
	
	public Player(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy, IActionStrategy actionStrategy,
			IUpdateStrategy updateStrategy, IMoveableStrategy moveableStrategy, 
			Point pos, Dimension screenSize) {
		super(paintStrategy, movementStrategy, actionStrategy, updateStrategy, pos, screenSize);
		_moveableStrategy = moveableStrategy;
	}
	
	public void setMoveableStrategy(IMoveableStrategy moveableStrategy) {
		_moveableStrategy = moveableStrategy;
	}
	
	public IMoveableStrategy getMoveableStrategy() {
		return _moveableStrategy;
	}
	
	public void setMoveableKeys(IMoveableKeys moveableKeys) {
		_moveableKeys = moveableKeys;
	}
	
	public IMoveableKeys getMoveableKeys() {
		return _moveableKeys;
	}
	
}
