package object.gameobjects.boss;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

import object.IGameObjectAdapter;
import object.gameobjects.impl.interactive.vagile.auto.AutoObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.MultiUpdate;
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
		this(pos, 16, 16, new BasicPaint(), gameObjectAdapter, new Collision(), 
				new ChangeState(), IMovementStrategy.NULL_MOVEMENT);
	}
	
	private void createPhases() {
		
		_phaseVisitor.put("spawn", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rockmancropped.png", 0.57, 0.98));
				DemoBoss.this.setUpdateStrategy(new SpawnBehaviour());
				DemoBoss.this.setInteractionStrategy(new SpawnToPhase1());
			}
			
		});
		
		_phaseVisitor.put("phase 1", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this.setUpdateStrategy(new MultiUpdate(new DetectBoundary(), new Phase1Detection()));
				DemoBoss.this.setInteractionStrategy(new Phase1Interaction());
				DemoBoss.this.setMovementStrategy(new BasicMovement());
			}
			
		});
		
	}
	
	public void changePhases(String id) {
		_phaseVisitor.get(id).execute();
	}

}
