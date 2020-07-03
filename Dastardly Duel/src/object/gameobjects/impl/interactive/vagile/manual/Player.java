package object.gameobjects.impl.interactive.vagile.manual;

import java.awt.Point;

import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.action.Block;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Bounce;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.BasicMoveable;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;

public class Player extends ManualObject {

	private Player(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy,
			IMoveableStrategy moveableStrategy, IMoveableKeys moveableKeys, IActionStrategy primaryAction,
			IActionStrategy secondaryAction) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy,
				moveableStrategy, moveableKeys, primaryAction, secondaryAction);
	}
	
	public Player(Point pos, IGameObject2ControlAdapter gameObject2Control) {
		this(pos, 36, 120, new BasicPaint(), gameObject2Control,
				new MultiUpdate(new DetectBoundary(), new MultiUpdate(new PseudoGravity(), new Collision())), 
				new Bounce(), new BasicMovement(), new BasicMoveable(), IMoveableKeys.STANDARD_KEYS, 
				new BoulderAttack(), new Block());
	}
	
	
	// State declaration methods -- Set state -- we'll use a visitor for this to be able to add more states!
	
	public void setState(String state) {
		
	}
	
	
	
	
	
	
	
	

}
