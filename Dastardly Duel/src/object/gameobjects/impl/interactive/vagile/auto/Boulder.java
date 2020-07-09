package object.gameobjects.impl.interactive.vagile.auto;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import object.IGameObjectAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Kill;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.ConstantMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.DetectBoundary;

public class Boulder extends AutoObject {
	
	private final String id = "boulder";

	private Boulder(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy);
	}
	
	public Boulder(Point pos, IGameObjectAdapter _gameObject2Control) {
		this(pos, 10, 10, new ImagePaint(new AffineTransform(), "images/projectile.png", 0.67, 0.67),
				_gameObject2Control, new DetectBoundary(), new Kill(), 
				new ConstantMovement());
	}
	
	@Override
	public String getID() {
		return id;
	}

}
