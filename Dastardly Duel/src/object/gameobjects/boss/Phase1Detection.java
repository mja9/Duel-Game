package object.gameobjects.boss;

import java.util.HashMap;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.impl.interactive.sessile.RockWall;
import object.gameobjects.impl.interactive.vagile.auto.Boulder;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.visitor.IVisitorAlgo;

public class Phase1Detection implements IUpdateStrategy{
	
	HashMap<String, IVisitorAlgo> _visitorDetection = new HashMap<String, IVisitorAlgo>();

	@Override
	public void init() {	
		_visitorDetection.put("player", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss _demoBoss = (DemoBoss) args[0];
				Player _player = (Player) args[1];
				_demoBoss.interact(_player.getID(), _player);
			}
			
		});
		
		_visitorDetection.put("projectile", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss _demoBoss = (DemoBoss) args[0];
				Boulder _projectile = (Boulder) args[1];
				
				// Check the x-position
				if(Math.abs(_demoBoss.getPosition().x - _projectile.getPosition().x) <= 
						_demoBoss.getWidth() / 2 + _projectile.getWidth() / 2) {
					
					// Check the y-positions
					if(Math.abs(_demoBoss.getPosition().y - _projectile.getPosition().y) <= 
							_demoBoss.getHeight() / 2 + _projectile.getHeight() / 2) {
						
						_demoBoss.interact(_projectile.getID(), _projectile);
					}
				}
				
			}
			
		});

		_visitorDetection.put("barrier", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
				DemoBoss _demoBoss = (DemoBoss) args[0];
				RockWall _barrier = (RockWall) args[1];
				
				// Check the x-position
				if(Math.abs(_demoBoss.getPosition().x - _barrier.getPosition().x) <= 
						_demoBoss.getWidth() / 2 + _barrier.getWidth() / 2) {
					
					// Check the y-positions
					if(Math.abs(_demoBoss.getPosition().y - _barrier.getPosition().y) <= 
							_demoBoss.getHeight() / 2 + _barrier.getHeight() / 2) {
						
						_demoBoss.interact(_barrier.getID(), _barrier);
					}
				}
			}
	
		});
		
		_visitorDetection.put("default", new IVisitorAlgo() {

			@Override
			public void execute(Object... args) {
			}
			
		});

	}

	@Override
	public void updateState(AInteractiveObject thisContext, IDispatcher<ICommand> dispatcher) {
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(AGameObject otherContext, IDispatcher<ICommand> dispatcher) {
				if(thisContext != otherContext) {
					
					if (_visitorDetection.containsKey(otherContext.getID())) {
						_visitorDetection.get(otherContext.getID()).execute(thisContext, otherContext);
					} else {
						_visitorDetection.get("default").execute(thisContext, otherContext);
					}

				}
			}
			
		});
	}

}
