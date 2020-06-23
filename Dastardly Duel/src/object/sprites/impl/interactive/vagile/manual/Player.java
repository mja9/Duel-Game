package object.sprites.impl.interactive.vagile.manual;

import java.awt.Point;

import object.IObject2ModelAdapter;
import object.sprites.movement.IMoveableKeys;
import object.sprites.movement.IMoveableStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class Player extends ManualObject {

	public Player(Point pos, int width, int height, IPaintStrategy paintStrategy, IObject2ModelAdapter object2Model,
			IUpdateStrategy updateStrategy, IMovementStrategy movementStrategy, IMoveableStrategy moveableStrategy,
			IMoveableKeys moveableKeys) {
		super(pos, width, height, paintStrategy, object2Model, updateStrategy, movementStrategy, moveableStrategy,
				moveableKeys);
	}

}
