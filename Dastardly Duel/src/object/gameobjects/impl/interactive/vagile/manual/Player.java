package object.gameobjects.impl.interactive.vagile.manual;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.BasicMoveable;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;

public class Player extends ManualObject {
	
	static int width = 36;
	static int height = 120;
	static IUpdateStrategy updateStrategy = new MultiUpdate(new DetectBoundary(), new MultiUpdate(new PseudoGravity(), new Collision()));
	static IInteractionStrategy interactStrategy = IInteractionStrategy.NULL_INTERACTION;
	static IMovementStrategy movementStrategy = new BasicMovement();
	static IMoveableStrategy moveableStrategy = new BasicMoveable();
	static IMoveableKeys moveableKeys = IMoveableKeys.STANDARD_KEYS;
	static IActionStrategy actionStrategy = new BoulderAttack();
	
	public Player(Point pos, IPaintStrategy paintStrategy, IGameObject2ControlAdapter gameObject2Control) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy, moveableStrategy,
				moveableKeys, actionStrategy);
	}

}
