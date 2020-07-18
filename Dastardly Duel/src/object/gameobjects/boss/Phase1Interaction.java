package object.gameobjects.boss;

import java.awt.Point;
import java.util.HashMap;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.impl.interactive.sessile.RockWall;
import object.gameobjects.impl.interactive.vagile.auto.Boulder;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import object.gameobjects.interaction.IInteractionStrategy;
import util.visitor.IVisitorAlgo;

public class Phase1Interaction implements IInteractionStrategy {
	
	private DemoBoss _demoBoss;
	
	private HashMap<String, IVisitorAlgo> _visitorInteraction = new HashMap<String, IVisitorAlgo>();

	@Override
	public void init(AInteractiveObject context) {
		_demoBoss = (DemoBoss) context;
		initVisitor();
	}
	
	private void initVisitor() {
		_visitorInteraction.put("left boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {	
				_demoBoss.setPosition(new Point(_demoBoss.getScreenSize().width - _demoBoss.getWidth() /
						2, _demoBoss.getPosition().y));
			}
			
		});
		
		_visitorInteraction.put("right boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {	
				_demoBoss.setPosition(new Point(_demoBoss.getWidth() / 2, _demoBoss.getPosition().y));
			}
			
		});
		
		_visitorInteraction.put("top boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {	
				_demoBoss.setPosition(new Point(_demoBoss.getPosition().x, _demoBoss.getHeight() / 2));
				_demoBoss.setSpeed(new Point(_demoBoss.getSpeed().x, 0));
			}
			
		});
		
		_visitorInteraction.put("bottom boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {	
				_demoBoss.setPosition(new Point(_demoBoss.getPosition().x, 
						_demoBoss.getScreenSize().height - 
						(_demoBoss.getScreenSize().height / 4) - (_demoBoss.getHeight() / 2)));
			}
			
		});
		
		_visitorInteraction.put("platform", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {				
			}
			
		});
		
		_visitorInteraction.put("barrier", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				RockWall otherContext = (RockWall) args[0];
				Point otherCenter = otherContext.getPosition();
				Point thisCenter = _demoBoss.getPosition();
				
				if ((Math.abs(otherCenter.x - thisCenter.x) <=
						_demoBoss.getWidth() / 2 + otherContext.getWidth() / 2)
						
						// Check y-positions
						&& (Math.abs(otherCenter.y - thisCenter.y) <=
						_demoBoss.getHeight() / 2 + otherContext.getHeight() / 2)) {
					
						// Left Side
						if (_demoBoss.getPosition().x + _demoBoss.getWidth() / 2 >=
								otherContext.getPosition().x - otherContext.getWidth() / 2) {
							_demoBoss.setPosition(new Point(otherContext.getPosition().x -
									otherContext.getWidth() / 2 - _demoBoss.getWidth() / 2, _demoBoss.getPosition().y));
						
						// Right side
						} else if(_demoBoss.getPosition().x - _demoBoss.getWidth() / 2 <= 
								otherContext.getPosition().x + otherContext.getWidth() / 2) {
							_demoBoss.setPosition(new Point(otherContext.getPosition().x + 
									otherContext.getWidth() / 2 + _demoBoss.getWidth() / 2, _demoBoss.getPosition().y));
						
						}
				}

			}
			
		});
		
		_visitorInteraction.put("projectile", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {	

				_demoBoss.damageBoss();
				System.out.println("Boss has been damaged!\n");
				
			}
			
		});
		
		_visitorInteraction.put("player", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {		
				
				Player otherContext = (Player) args[0];
				Point otherCenter = otherContext.getPosition();
				Point thisCenter = _demoBoss.getPosition();
				int thresholdDist = 15;

				
				if ((Math.abs(otherCenter.x - thisCenter.x) <=
						_demoBoss.getWidth() / 2 + otherContext.getWidth() / 2)
						
						// Check y-positions
						&& (Math.abs(otherCenter.y - thisCenter.y) <=
						_demoBoss.getHeight() / 2 + otherContext.getHeight() / 2)) {
					
					System.out.println("Boss attacks the player!\n");
					
				} else if (Math.abs(_demoBoss.getPosition().x - otherContext.getPosition().x) > 
				_demoBoss.getWidth() / 2 + otherContext.getWidth() / 2 + thresholdDist) {
					
					if (otherCenter.x < thisCenter.x) {
						_demoBoss.setSpeed(new Point(-3, 0));
					} else {
						_demoBoss.setSpeed(new Point(3, 0));
					}
					
				} else {
					_demoBoss.setSpeed(new Point(0, 0));
				}
			}
			
		});
		
		_visitorInteraction.put("default", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {				
			}
			
		});
	}

	@Override
	public void interact(String id, Object... args) {
		_visitorInteraction.get(id).execute(args);
	}

}
