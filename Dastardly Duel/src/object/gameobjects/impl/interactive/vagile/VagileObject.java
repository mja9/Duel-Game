package object.gameobjects.impl.interactive.vagile;

import java.awt.Point;

import object.IGameObjectAdapter;
import object.IObject2ViewAdapter;
import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class VagileObject extends AInteractiveObject {
	
	private final String ID = "vagile";
	
	IMovementStrategy _movementStrategy = IMovementStrategy.NULL_MOVEMENT;

	public VagileObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy, 
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
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
