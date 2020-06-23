package object.sprites.impl.interactive.vagile;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.impl.interactive.AInteractiveObject;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class VagileObject extends AInteractiveObject {
	
	private final String ID = "vagile";
	
	IMovementStrategy _movementStrategy = IMovementStrategy.NULL_MOVEMENT;

	public VagileObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IObject2ViewAdapter object2Model, IUpdateStrategy updateStrategy, 
			IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, object2Model, updateStrategy);
		_movementStrategy = movementStrategy;
		_movementStrategy.init(this);
	}

	@Override
	public void move() {
		_movementStrategy.move();
	}

	@Override
	public String getID() {
		return ID;
	}
	
}
