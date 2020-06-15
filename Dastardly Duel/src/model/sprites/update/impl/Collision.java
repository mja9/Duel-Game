package model.sprites.update.impl;

import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Collision implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(ASprite thisContext, IDispatcher<ICommand> dispatcher) {
		
		Point thisCenter = thisContext.getPosition();
		
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(ASprite otherContext, IDispatcher<ICommand> dispatcher) {
				if (otherContext != thisContext) {
					
					Point otherCenter = otherContext.getPosition();
					
					// Check x-positions
					if ((Math.abs(otherCenter.x - thisCenter.x) <=
							thisContext.getWidth() / 2 + otherContext.getWidth() / 2)
							// Check y-positions
							&& (Math.abs(otherCenter.y - thisCenter.y) <=
							thisContext.getHeight() / 2 + otherContext.getHeight() / 2)) {
						System.out.println("Collision Detected!\n");
						performAction(thisContext, otherContext);
					}
					
				}
			}
			
		});
	}
	
	// For testing purposes only!
	private void performAction(ASprite thisContext, ASprite otherContext) {
		
		// If the sprites are at the proper heights -- they will collide from the side
		if (Math.abs(thisContext.getPosition().y - otherContext.getPosition().y) <= 
				thisContext.getHeight() / 2 + otherContext.getHeight() / 2) {
			
			// Right side of OTHER context collides off left side of THIS context
			
			if (otherContext.getPosition().x + otherContext.getWidth() / 2 >= 
					thisContext.getPosition().x - thisContext.getWidth() / 2) {
				otherContext.setPosition(
						new Point(thisContext.getPosition().x - thisContext.getWidth() / 2 -
								otherContext.getWidth() / 2, otherContext.getPosition().y));
				otherContext.setSpeed(new Point(0, otherContext.getSpeed().y));
			}
			
			// Left side of OTHER context collides off right side of THIS context
			if (otherContext.getPosition().x - otherContext.getWidth() / 2 <= 
					thisContext.getPosition().x + thisContext.getWidth() / 2) {
				otherContext.setPosition(
						new Point(thisContext.getPosition().x + thisContext.getWidth() / 2 +
								otherContext.getWidth() / 2, otherContext.getPosition().y));
				otherContext.setSpeed(new Point(0, otherContext.getSpeed().y));
			}
			
			
		}
		
		// Collide off of top
		
		// Collide off of bottom
	}

}
