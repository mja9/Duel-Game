package object.sprites.impl.interactive.vagile.manual;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.action.BoulderAttack;
import object.sprites.action.IActionStrategy;
import object.sprites.movement.IMoveableKeys;
import object.sprites.movement.IMoveableStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.movement.impl.BasicMoveable;
import object.sprites.movement.impl.BasicMovement;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;
import object.sprites.update.impl.Bounce;
import object.sprites.update.impl.Collision;
import object.sprites.update.impl.MultiUpdate;
import object.sprites.update.impl.PseudoGravity;

public class Player extends ManualObject {
	
	static int width = 36;
	static int height = 120;
	static IUpdateStrategy updateStrategy = new MultiUpdate(new Bounce(), new MultiUpdate(new PseudoGravity(), new Collision()));
	static IMovementStrategy movementStrategy = new BasicMovement();
	static IMoveableStrategy moveableStrategy = new BasicMoveable();
	static IMoveableKeys moveableKeys = IMoveableKeys.STANDARD_KEYS;
	static IActionStrategy actionStrategy = new BoulderAttack();
	
	public Player(Point pos, IPaintStrategy paintStrategy, IObject2ViewAdapter object2View) {
		super(pos, width, height, paintStrategy, object2View, updateStrategy, movementStrategy, moveableStrategy,
				moveableKeys, actionStrategy);
	}

}
