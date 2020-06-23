package object.sprites.impl.interactive.vagile.manual;

import java.awt.Point;

import object.IObject2ModelAdapter;
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

	public ManualObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IObject2ModelAdapter object2Model, IUpdateStrategy updateStrategy, IMovementStrategy movementStrategy, 
			IMoveableStrategy moveableStrategy, IMoveableKeys moveableKeys) {
		super(pos, width, height, paintStrategy, object2Model, updateStrategy, movementStrategy);
		_moveableStrategy = moveableStrategy;
		_moveableKeys = moveableKeys;
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
	
	@Override 
	public String getID() {
		return ID;
	}

}
