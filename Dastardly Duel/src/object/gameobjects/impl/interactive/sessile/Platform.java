package object.gameobjects.impl.interactive.sessile;

import java.awt.Point;

import object.IGameObjectAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.update.IUpdateStrategy;

public class Platform extends SessileObject {
	
	private final String id = "platform";

	private Platform(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
	}
	
	public Platform(Point pos, int width, int height, IGameObjectAdapter gameObject2Control) {
		this(pos, width, height, new BasicPaint(), gameObject2Control, IUpdateStrategy.NULL_UPDATE, 
				IInteractionStrategy.NULL_INTERACTION);
	}
	
	@Override
	public String getID() {
		return id;
	}
}
