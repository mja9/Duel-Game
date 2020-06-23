package object.sprites.impl.interactive.vagile.manual;

import java.awt.Point;

import object.sprites.IGameObject2ControlAdapter;
import object.sprites.action.IActionStrategy;
import object.sprites.impl.interactive.vagile.VagileObject;
import object.sprites.movement.IMoveableKeys;
import object.sprites.movement.IMoveableStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class ManualObject extends VagileObject{
	
	private final String ID = "manual";
	
	IMoveableStrategy _moveableStrategy = IMoveableStrategy.NULL_MOVEABLE;
	
	IMoveableKeys _moveableKeys = IMoveableKeys.STANDARD_KEYS;
	
	IActionStrategy _actionStrategy = IActionStrategy.NULL_ACTION;

	public ManualObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy, IMovementStrategy movementStrategy, 
			IMoveableStrategy moveableStrategy, IMoveableKeys moveableKeys, IActionStrategy actionStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, movementStrategy);
		_moveableStrategy = moveableStrategy;
		_moveableStrategy.init(this);
		_moveableKeys = moveableKeys;
		_actionStrategy = actionStrategy;
		_actionStrategy.init(this);
	}
	
	public IMoveableStrategy getMoveableStrategy() {
		return _moveableStrategy;
	}
	
	public void setMoveableStrategy(IMoveableStrategy newStrat) {
		_moveableStrategy = newStrat;
	}
	
	public IMoveableKeys getMoveableKeys() {
		return _moveableKeys;
	}
	
	public void setMoveableKeys(IMoveableKeys newKeys) {
		_moveableKeys = newKeys;
	}
	
	public void act() {
		_actionStrategy.performAction();
	}
	
	@Override 
	public String getID() {
		return ID;
	}

}
