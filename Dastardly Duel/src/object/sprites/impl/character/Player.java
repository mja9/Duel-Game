package object.sprites.impl.character;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import object.sprites.ASprite;
import object.sprites.action.IActionStrategy;
import object.sprites.movement.IMoveableKeys;
import object.sprites.movement.IMoveableStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

/**
 * A sprite defined by its ability to be controlled by the gamer.
 * @author miguelarana
 *
 */
public class Player extends ASprite {
	
	private IMoveableStrategy _moveableStrategy = IMoveableStrategy.NULL_MOVEABLE;
	
	private IMoveableKeys _moveableKeys = IMoveableKeys.STANDARD_KEYS;
	
	private final String ID = "player";
	
	public Player(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy, IActionStrategy actionStrategy,
			IUpdateStrategy updateStrategy, IMoveableStrategy moveableStrategy, 
			Point pos, Dimension screenSize, int width, int height, Component canvas) {
		super(paintStrategy, movementStrategy, actionStrategy, updateStrategy, pos, screenSize, width, height, canvas);
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

	@Override
	public String getID() {
		return ID;
	}
	
}
