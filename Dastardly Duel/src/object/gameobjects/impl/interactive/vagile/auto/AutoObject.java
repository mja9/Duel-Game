package object.gameobjects.impl.interactive.vagile.auto;

import java.awt.Point;

import object.IGameObjectAdapter;
import object.IObject2ViewAdapter;
import object.gameobjects.impl.interactive.vagile.VagileObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class AutoObject extends VagileObject {
	
	private final String ID = "auto";

	public AutoObject(Point pos, int width, int height, IPaintStrategy paintStrategy, IGameObjectAdapter gameObject2Control,
			IUpdateStrategy updateStrategy, IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy);
	}
	
	@Override
	public String getID() {
		return ID;
	}

}
