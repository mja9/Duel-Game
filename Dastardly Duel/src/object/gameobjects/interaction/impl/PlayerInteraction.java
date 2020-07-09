package object.gameobjects.interaction.impl;

import java.awt.Point;
import java.util.HashMap;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.impl.interactive.sessile.Platform;
import object.gameobjects.impl.interactive.sessile.RockWall;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import object.gameobjects.interaction.IInteractionStrategy;
import util.visitor.IVisitorAlgo;

public class PlayerInteraction implements IInteractionStrategy {
	
	private Player _context;
	
	private HashMap<String, IVisitorAlgo> _visitorInteraction = new HashMap<String, IVisitorAlgo>();

	@Override
	public void init(AInteractiveObject context) {
		_context = (Player) context;
		initVisitor();
	}
	
	private void initVisitor() {
		
		_visitorInteraction.put("left boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				_context.setPosition(new Point(_context.getWidth() / 2, _context.getPosition().y));
			}
			
		});
		
		_visitorInteraction.put("right boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				_context.setPosition(new Point(_context.getScreenSize().width - _context.getWidth() /
						2, _context.getPosition().y));
			}
			
		});
		
		_visitorInteraction.put("top boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				_context.setPosition(new Point(_context.getPosition().x, _context.getHeight() / 2));
				_context.setSpeed(new Point(_context.getSpeed().x, 0));
			}
			
		});
		
		_visitorInteraction.put("bottom boundary", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				_context.setPosition(new Point(_context.getPosition().x, 
						_context.getScreenSize().height - 
						(_context.getScreenSize().height / 4) - (_context.getHeight() / 2)));
				((Player) _context).changeState("ground");
			}
			
		});
		
		_visitorInteraction.put("platform", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				
				Platform otherContext = (Platform) args[0];
				// Find the player's old position
				Point oldPos = new Point(_context.getPosition().x - _context.getSpeed().x,
						_context.getPosition().y - _context.getSpeed().y);
					
					// Hit the top
					if ((oldPos.y + _context.getHeight() / 2 < otherContext.getPosition().y - otherContext.getHeight() / 2) &&
							_context.getSpeed().y > 0 &&
							(oldPos.x >= otherContext.getPosition().x - otherContext.getWidth() / 2 & 
							oldPos.x <= otherContext.getPosition().x + otherContext.getWidth() / 2)) {
						_context.setPosition(new Point(_context.getPosition().x,
								otherContext.getPosition().y - (otherContext.getHeight() / 2) - (_context.getHeight() / 2)));
						_context.setSpeed(new Point(_context.getSpeed().x, 0));
						 _context.changeState("ground");
					}	
			}
			
		});
		
		_visitorInteraction.put("rock wall", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
			
				RockWall otherContext = (RockWall) args[0];
				
				// Left Side
				if (_context.getPosition().x + _context.getWidth() / 2 >=
						otherContext.getPosition().x - otherContext.getWidth() / 2) {
//					System.out.println("Hit the left side\n");
					_context.setPosition(new Point(otherContext.getPosition().x -
							otherContext.getWidth() / 2 - _context.getWidth() / 2, _context.getPosition().y));
				
				// Right side
				} else if(_context.getPosition().x - _context.getWidth() / 2 <= 
						otherContext.getPosition().x + otherContext.getWidth() / 2) {
//					System.out.println("Hit the right side\n");
					_context.setPosition(new Point(otherContext.getPosition().x + 
							otherContext.getWidth() / 2 + _context.getWidth() / 2, _context.getPosition().y));
				}
			}
			
		});
		
		_visitorInteraction.put("boulder", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {
				System.out.println("Decrement player health here!\n");
			}
			
		});
		
		_visitorInteraction.put("default", new IVisitorAlgo() {

			@Override
			public void execute(Object ... args) {	
			}
			
		});
		
	}

	@Override
	public void interact(String id, Object ... args) {
		
		if (_visitorInteraction.containsKey(id)) {
			_visitorInteraction.get(id).execute(args);
			
		} else {
			_visitorInteraction.get("default").execute(args);
		}
		
	}

}
