package object.sprites.impl.interactive.vagile.auto;

import java.awt.Point;

import object.IObject2ModelAdapter;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class Boulder extends AutoObject {
	
	private final String ID = "boulder";
	
	public Boulder(Point pos, int width, int height, IPaintStrategy paintStrategy, IObject2ModelAdapter object2Model,
			IUpdateStrategy updateStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, object2Model, updateStrategy, movementStrategy);
	}

	@Override
	public String getID() {
		return ID;
	}

}
