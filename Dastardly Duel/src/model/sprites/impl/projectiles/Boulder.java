package model.sprites.impl.projectiles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;

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
