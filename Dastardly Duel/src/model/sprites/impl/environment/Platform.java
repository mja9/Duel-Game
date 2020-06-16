package model.sprites.impl.environment;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.ImageObserver;

import model.sprites.ASprite;
import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

public class Platform extends ASprite {
	
	private final String ID = "platform";

	public Platform(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy, IActionStrategy actionStrategy,
			IUpdateStrategy updateStrategy, Point pos, Dimension screenSize, int width, int height, ImageObserver canvas) {
		super(paintStrategy, movementStrategy, actionStrategy, updateStrategy, pos, screenSize, width, height, canvas);
	}

	@Override
	public String getID() {
		return ID;
	}

}
