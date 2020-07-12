package object.gameobjects.boss;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

import javax.swing.Timer;

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
	
	// States controlling immune stages for boss
	private int _health = 100;
	
	public enum States {
		DAMAGEABLE, 
		IMMUNE;
	}
	
	private States _currentState = States.IMMUNE;
	
	private int _damageGracePeriod = 3000;
	
	private Timer _gracePeriodTimer = new Timer(_damageGracePeriod, (e) -> revertToDamageable());
	
	// Phases controlling boss behaviour during encounters
	private String _nextPhase = "transition 1";
	
	private HashMap<String, IVisitorAlgo> _phaseVisitor = new HashMap<String, IVisitorAlgo>();
	
	private DemoBoss(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy,
			IInteractionStrategy interactStrategy, IMovementStrategy movementStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control, updateStrategy, interactStrategy, movementStrategy);
		createPhases();
	}
		
	public DemoBoss(Point pos, IGameObjectAdapter gameObjectAdapter) {
		this(pos, 16, 16, new BasicPaint(), gameObjectAdapter, new Collision(), 
				new ChangeState(), IMovementStrategy.NULL_MOVEMENT);
	}
	
	private void createPhases() {
		
		_phaseVisitor.put("transition 1", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rockmancropped.png", 0.57, 0.98));
				DemoBoss.this.setUpdateStrategy(new SpawnBehaviour());
				_nextPhase = "phase 1";
			}
			
		});
		
		_phaseVisitor.put("phase 1", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this._currentState = States.DAMAGEABLE;
				DemoBoss.this.setUpdateStrategy(new MultiUpdate(new DetectBoundary(), new Phase1Detection()));
				DemoBoss.this.setInteractionStrategy(new Phase1Interaction());
				DemoBoss.this.setMovementStrategy(new BasicMovement());
				_nextPhase = "transition 2";
			}
			
		});
		
		_phaseVisitor.put("transition 2", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this._currentState = States.IMMUNE;
				DemoBoss.this.setSpeed(new Point(4, 0));
				DemoBoss.this.setUpdateStrategy(new Transition2Behaviour());
				DemoBoss.this.setInteractionStrategy(new ChangeState());
				_nextPhase = "phase 2";
				System.out.println(DemoBoss.this);
			}
			
		});
		
		_phaseVisitor.put("phase 2", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this._currentState = States.DAMAGEABLE;
				DemoBoss.this.setUpdateStrategy(new MultiUpdate(new DetectBoundary(), new Phase1Detection()));
				DemoBoss.this.setInteractionStrategy(new Phase2Interaction());
				_nextPhase = "transition 3";
			}
			
		});
		
		_phaseVisitor.put("transition 3", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this._currentState = States.IMMUNE;
				_nextPhase = "phase 3";
			}
			
		});
		
		_phaseVisitor.put("phase 3", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this._currentState = States.DAMAGEABLE;
				_nextPhase = "death";
			}
			
		});
		
		_phaseVisitor.put("death", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss.this._currentState = States.IMMUNE;
			}
			
		});
		
	}
	
	
	// He must be damageable and changing states earlier than he should be 
	
	private void revertToDamageable() {
		_currentState = States.DAMAGEABLE;
		_gracePeriodTimer.stop();
	}
	
	public void damageBoss() {
		switch (_currentState) {
			
			case DAMAGEABLE:
				_health -= 15;
				if (_health == 70) {
					changePhases();
				}
				_currentState = States.IMMUNE;
				_gracePeriodTimer.start();
				break;
			
			case IMMUNE:
				break;
		}
	}
	
	public void changePhases() {
		_phaseVisitor.get(_nextPhase).execute();
	}

}
