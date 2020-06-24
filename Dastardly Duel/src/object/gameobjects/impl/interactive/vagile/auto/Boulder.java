package object.gameobjects.impl.interactive.vagile.auto;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class Boulder extends AutoObject {
	
	private final String ID = "boulder";
	
	public Boulder(Point pos, int width, int height, IPaintStrategy paintStrategy, IGameObject2ControlAdapter gameObject2Control,
			IUpdateStrategy updateStrategy, IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy,interactStrategy, movementStrategy);
	}

	@Override
	public String getID() {
		return ID;
	}

}
