package object.sprites.impl.interactive.vagile.auto;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.IGameObject2ControlAdapter;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class Boulder extends AutoObject {
	
	private final String ID = "boulder";
	
	public Boulder(Point pos, int width, int height, IPaintStrategy paintStrategy, IGameObject2ControlAdapter gameObject2Control,
			IUpdateStrategy updateStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, movementStrategy);
	}

	@Override
	public String getID() {
		return ID;
	}

}
