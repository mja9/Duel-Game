package object.gameobjects.impl.interactive.vagile.auto;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.impl.interactive.vagile.VagileObject;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class AutoObject extends VagileObject {
	
	private final String ID = "auto";

	public AutoObject(Point pos, int width, int height, IPaintStrategy paintStrategy, IGameObject2ControlAdapter gameObject2Control,
			IUpdateStrategy updateStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, movementStrategy);
	}
	
	@Override
	public String getID() {
		return ID;
	}

}
