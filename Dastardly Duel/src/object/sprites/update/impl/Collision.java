package object.sprites.update.impl;

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
						performAction(thisContext, otherContext);
					}
					
				}
			}
			
		});
	}
	
	// For testing purposes only!
	private void performAction(ASprite thisContext, ASprite otherContext) {
		
		// Find where otherContext was positioned before
		Point oldPos = new Point(thisContext.getPosition().x - thisContext.getSpeed().x,
				thisContext.getPosition().y - thisContext.getSpeed().y);
		
//		if ((oldPos.x - thisContext.getWidth() / 2 < otherContext.getPosition().x + otherContext.getWidth() / 2)
//				| (oldPos.x + thisContext.getWidth() / 2 > otherContext.getPosition().x - otherContext.getWidth() / 2)) {
			
			// Hit the top
			if ((oldPos.y < otherContext.getPosition().y - otherContext.getHeight() / 2) && thisContext.getSpeed().y > 0) {
				thisContext.setPosition(new Point(thisContext.getPosition().x,
						otherContext.getPosition().y - (otherContext.getHeight() / 2) - (thisContext.getHeight() / 2)));
				thisContext.setSpeed(new Point(thisContext.getSpeed().x, 0));
			}
			
			// Hit the bottom
//			if (oldPos.y > otherContext.getPosition().y + otherContext.getHeight() / 2) {
//				thisContext.setPosition(new Point(thisContext.getPosition().x, 
//						otherContext.getPosition().y + otherContext.getHeight() + thisContext.getHeight()));
//				thisContext.setSpeed(new Point(thisContext.getSpeed().x, 0));
//			}
			
		// Hit the right
//		} else if (oldPos.x > otherContext.getPosition().x + otherContext.getWidth() / 2) {
//			thisContext.setPosition(new Point(otherContext.getPosition().x + otherContext.getWidth() / 2 +
//					thisContext.getWidth() / 2, thisContext.getPosition().y));
//			thisContext.setSpeed(new Point(0, thisContext.getSpeed().y));
//			
//		// Hit the left
//		} else {
//			thisContext.setPosition(new Point(otherContext.getPosition().x - otherContext.getWidth() / 2 - 
//					thisContext.getWidth() / 2, thisContext.getPosition().y));
//			thisContext.setSpeed(new Point(0, thisContext.getSpeed().y));
//		}
		
		
	}
	
//	// Find where otherContext was positioned before
//			Point oldPos = new Point(otherContext.getPosition().x - otherContext.getSpeed().x,
//					otherContext.getPosition().y - otherContext.getSpeed().y);
//			
//			if ((oldPos.x - otherContext.getWidth() / 2 < thisContext.getPosition().x + thisContext.getWidth() / 2)
//					| (oldPos.x + otherContext.getWidth() / 2 > thisContext.getPosition().x - thisContext.getWidth() / 2)) {
//				
//				// Hit the top
//				if (oldPos.y < thisContext.getPosition().y - thisContext.getHeight() / 2) {
//					otherContext.setPosition(new Point(otherContext.getPosition().x,
//							thisContext.getPosition().y - (thisContext.getHeight() / 2) - (otherContext.getHeight() / 2)));
//					otherContext.setSpeed(new Point(otherContext.getSpeed().x, 0));
//				}
//				
//				// Hit the bottom
//				if (oldPos.y > thisContext.getPosition().y + thisContext.getHeight() / 2) {
//					otherContext.setPosition(new Point(otherContext.getPosition().x, 
//							thisContext.getPosition().y + thisContext.getHeight() + otherContext.getHeight()));
//					otherContext.setSpeed(new Point(otherContext.getSpeed().x, 0));
//				}
//				
//			// Hit the right
//			} else if (oldPos.x > thisContext.getPosition().x + thisContext.getWidth() / 2) {
//				otherContext.setPosition(new Point(thisContext.getPosition().x + thisContext.getWidth() / 2 +
//						otherContext.getWidth() / 2, otherContext.getPosition().y));
//				otherContext.setSpeed(new Point(0, otherContext.getSpeed().y));
//				
//			// Hit the left
//			} else {
//				otherContext.setPosition(new Point(thisContext.getPosition().x - thisContext.getWidth() / 2 - 
//						otherContext.getWidth() / 2, otherContext.getPosition().y));
//				otherContext.setSpeed(new Point(0, otherContext.getSpeed().y));
//			}
	
}
