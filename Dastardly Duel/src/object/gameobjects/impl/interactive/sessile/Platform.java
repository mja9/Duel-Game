package object.gameobjects.impl.interactive.sessile;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class Platform extends SessileObject {
	
	public Platform(Point pos, int width, int height, IPaintStrategy paintStrategy, IGameObject2ControlAdapter gameObject2Control,
			IUpdateStrategy updateStrategy, IInteractionStrategy interactStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
	}

	private final String ID = "platform";

	@Override
	public String getID() {
		return ID;
	}

}
