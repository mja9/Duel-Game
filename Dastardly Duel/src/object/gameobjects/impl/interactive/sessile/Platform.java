package object.gameobjects.impl.interactive.sessile;

import java.awt.Point;

import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.update.IUpdateStrategy;

public class Platform extends SessileObject {

	private Platform(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
	}
	
	public Platform(Point pos, int width, int height, IGameObject2ControlAdapter gameObject2Control) {
		this(pos, width, height, new BasicPaint(), gameObject2Control, IUpdateStrategy.NULL_UPDATE, 
				IInteractionStrategy.NULL_INTERACTION);
	}
}
