package object.gameobjects.impl.interactive.vagile.auto;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import object.IGameObjectAdapter;
import object.gameobjects.action.Block;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.DemoBossInteraction;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.AOEDetection;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;

public class DemoBoss extends AutoObject {

	private DemoBoss(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy);
	}
	
	// need to add tailored interaction and moveable strategy to the enemy
	
	public DemoBoss(Point pos, IGameObjectAdapter gameObjectAdapter) {
		this(pos, 86, 153, new ImagePaint(new AffineTransform(), "images/rockmancentered.png", 0.57, 0.98), gameObjectAdapter,
				new MultiUpdate(new MultiUpdate(new DetectBoundary(), new MultiUpdate(new PseudoGravity(), new Collision())), new AOEDetection()), 
				new DemoBossInteraction(), new BasicMovement());
	}
	
	public void startAI() {
		
	}
	
	private void enemyAI() {
		
	}

}
