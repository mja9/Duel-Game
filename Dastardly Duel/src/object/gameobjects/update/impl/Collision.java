package object.gameobjects.update.impl;

import java.awt.Point;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Collision implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(AInteractiveObject thisContext, IDispatcher<ICommand> dispatcher) {
		
		Point thisCenter = thisContext.getPosition();
		
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(AGameObject otherContext, IDispatcher<ICommand> dispatcher) {
				if (otherContext != thisContext) {
					
					Point otherCenter = otherContext.getPosition();
					
					// Check x-positions
					if ((Math.abs(otherCenter.x - thisCenter.x) <=
							thisContext.getWidth() / 2 + otherContext.getWidth() / 2)
							// Check y-positions
							&& (Math.abs(otherCenter.y - thisCenter.y) <=
							thisContext.getHeight() / 2 + otherContext.getHeight() / 2)) {
						performAction(thisContext, otherContext);
					}
					
				}
			}
			
		});
	}
	
	private void performAction(AGameObject thisContext, AGameObject otherContext) {
		
		// Find where otherContext was positioned before
		Point oldPos = new Point(thisContext.getPosition().x - thisContext.getSpeed().x,
				thisContext.getPosition().y - thisContext.getSpeed().y);
			
			// Hit the top
			if ((oldPos.y < otherContext.getPosition().y - otherContext.getHeight() / 2) && thisContext.getSpeed().y > 0) {
				thisContext.setPosition(new Point(thisContext.getPosition().x,
						otherContext.getPosition().y - (otherContext.getHeight() / 2) - (thisContext.getHeight() / 2)));
				thisContext.setSpeed(new Point(thisContext.getSpeed().x, 0));
				((Player) thisContext).changeState("ground");
			}
		
	}
	
}
