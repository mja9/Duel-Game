package object.sprites.impl.interactive.sessile;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.IGameObject2ControlAdapter;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class Platform extends SessileObject {
	
	public Platform(Point pos, int width, int height, IPaintStrategy paintStrategy, IGameObject2ControlAdapter gameObject2Control,
			IUpdateStrategy updateStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy);
	}

	private final String ID = "platform";

	@Override
	public String getID() {
		return ID;
	}

}
