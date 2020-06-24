package object.gameobjects.impl.interactive.sessile;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class SessileObject extends AInteractiveObject {
	
	private final String ID = "sessile";

	public SessileObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy, 
			IInteractionStrategy interactStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
	}

	@Override
	public void move() {		
	}
	
	@Override
	public String getID() {
		return ID;
	}

}
