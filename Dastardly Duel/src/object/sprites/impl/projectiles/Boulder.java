package object.sprites.impl.projectiles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import object.sprites.ASprite;
import object.sprites.action.IActionStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class Boulder extends ASprite {
	
	private final String ID = "projectile";

	public Boulder(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy, IActionStrategy actionStrategy,
			IUpdateStrategy updateStrategy, Point pos, Dimension screenSize, int width, int height, Component canvas) {
		super(paintStrategy, movementStrategy, actionStrategy, updateStrategy, pos, screenSize, width, height, canvas);
	}

	@Override
	public String getID() {
		return ID;
	}

}
