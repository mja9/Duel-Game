package object.gameobjects.impl.interactive.vagile.manual;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.function.Consumer;

import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.action.Block;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Bounce;
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

public class Player extends ManualObject {
	
	HashMap<String, Consumer<String>> _stateVisitor = new HashMap<String, Consumer<String>>();
	
	private Player(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy,
			IMoveableStrategy moveableStrategy, IMoveableKeys moveableKeys, IActionStrategy primaryAction,
			IActionStrategy secondaryAction) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy,
				moveableStrategy, moveableKeys, primaryAction, secondaryAction);
	}
	
	public Player(Point pos, IGameObject2ControlAdapter gameObject2Control) {
		this(pos, 36, 120, new ImagePaint(new AffineTransform(), "images/rockmancropped.png"), gameObject2Control,
				new MultiUpdate(new DetectBoundary(), new MultiUpdate(new PseudoGravity(), new Collision())), 
				new Bounce(), new BasicMovement(), new GroundMoveable(), IMoveableKeys.STANDARD_KEYS, 
				new BoulderAttack(), new Block());
		createStateVisitor();
	}
	
	private void createStateVisitor() {
		_stateVisitor.put("ground", new Consumer<String>() {

			@Override
			public void accept(String t) {
				Player.this.setMoveableStrategy(new GroundMoveable());
			}
			
		});
		
		_stateVisitor.put("air", new Consumer<String>() {

			@Override
			public void accept(String t) {
				Player.this.setMoveableStrategy(new InAirMoveable());
			}
			
		});
	}
	
	public void changeState(String state) {
		_stateVisitor.get(state).accept(state);
	}
	
	
	
	
	
	
	
	

}
