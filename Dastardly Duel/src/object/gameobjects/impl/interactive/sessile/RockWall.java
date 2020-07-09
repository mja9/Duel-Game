package object.gameobjects.impl.interactive.sessile;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import object.IGameObjectAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Kill;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.Rise;

public class RockWall extends SessileObject {
	
	private final String id = "barrier";

	private RockWall(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
	}
	
	public RockWall(Point pos, IGameObjectAdapter gameObject2Control) {
		this(pos, 16, 0, new ImagePaint(new AffineTransform(), "images/rockwall.png", 0.82, 0.95), 
				gameObject2Control, new Rise(), new Kill());
	}
	
	@Override
	public String getID() {
		return id;
	}

}
