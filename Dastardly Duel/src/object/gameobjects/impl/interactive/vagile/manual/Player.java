package object.gameobjects.impl.interactive.vagile.manual;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.function.Consumer;

import object.IGameObjectAdapter;
import object.gameobjects.action.Block;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.PlayerInteraction;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.GroundMoveable;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.movement.impl.InAirMoveable;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;
import util.visitor.IVisitorAlgo;

public class Player extends ManualObject {
	
	private final String id = "player";
	
	HashMap<String, IVisitorAlgo> _stateVisitor = new HashMap<String, IVisitorAlgo>();
	
	private Player(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy,
			IMoveableStrategy moveableStrategy, IMoveableKeys moveableKeys, IActionStrategy primaryAction,
			IActionStrategy secondaryAction) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy,
				moveableStrategy, moveableKeys, primaryAction, secondaryAction);
	}
	
	public Player(Point pos, IGameObjectAdapter gameObject2Control) {
		this(pos, 36, 103, new ImagePaint(new AffineTransform(), "images/rockmanpx.png", 0.57, 0.98), gameObject2Control,
				new MultiUpdate(new DetectBoundary(), new MultiUpdate(new PseudoGravity(), new Collision())), 
				new PlayerInteraction(), new BasicMovement(), new GroundMoveable(), IMoveableKeys.STANDARD_KEYS, 
				new BoulderAttack(), new Block());
		createStateVisitor();
	}
	
	private void createStateVisitor() {
		_stateVisitor.put("ground", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				Player.this.setMoveableStrategy(new GroundMoveable());
			}
			
		});
		
		_stateVisitor.put("air", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				Player.this.setMoveableStrategy(new InAirMoveable());
			}
			
		});
	}
	
	public void changeState(String state) {
		_stateVisitor.get(state).execute();
	}
	
	@Override
	public String getID() {
		return id;
	}
	
	
	
	
	

}
