package object.sprites.impl.interactive.sessile;

import java.awt.Point;

import object.IObject2ModelAdapter;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class Platform extends SessileObject {
	
	public Platform(Point pos, int width, int height, IPaintStrategy paintStrategy, IObject2ModelAdapter object2Model,
			IUpdateStrategy updateStrategy) {
		super(pos, width, height, paintStrategy, object2Model, updateStrategy);
	}

	private final String ID = "platform";

	@Override
	public String getID() {
		return ID;
	}

}
