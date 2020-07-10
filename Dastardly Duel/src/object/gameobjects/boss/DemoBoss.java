package object.gameobjects.boss;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

import object.IGameObjectAdapter;
import object.gameobjects.action.Block;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.impl.interactive.vagile.auto.AutoObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.AOEDetection;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;
import util.visitor.IVisitorAlgo;

public class DemoBoss extends AutoObject {
	
	private HashMap<String, IVisitorAlgo> _phaseVisitor = new HashMap<String, IVisitorAlgo>();

	private DemoBoss(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy);
		createPhases();
	}
	
	// need to add tailored interaction and moveable strategy to the enemy
	
	public DemoBoss(Point pos, IGameObjectAdapter gameObjectAdapter) {
		this(pos, 16, 16, new BasicPaint(), gameObjectAdapter, IUpdateStrategy.NULL_UPDATE, 
				IInteractionStrategy.NULL_INTERACTION, IMovementStrategy.NULL_MOVEMENT);
	}
	
	private void createPhases() {
		
		_phaseVisitor.put("phase 1", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rockmancropped.png", 0.57, 0.98));
			}
			
		});
		
	}
	
	public void changePhases(String id) {
		
	}
	
	public void startDemoBossEncounter() {
		
	}

}
