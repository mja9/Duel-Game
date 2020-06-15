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
		
		Point thisPosition = thisContext.getPosition();
		
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(ASprite otherContext, IDispatcher<ICommand> dispatcher) {
				if (otherContext != thisContext) {
					
					Point othersPos = otherContext.getPosition();
					
					// Check x-position -- check left side
					if (((othersPos.x - otherContext.getWidth() <= thisPosition.x - thisContext.getWidth())
							| (othersPos.x - otherContext.getWidth() <= thisPosition.x + thisContext.getWidth()))
							// Check right side
							| ((othersPos.x + otherContext.getWidth() <= thisPosition.x - thisContext.getWidth())
							| (othersPos.x + otherContext.getWidth() <= thisPosition.x + thisContext.getWidth()))) {
						
						// Check y-position -- check top side
						if (((othersPos.y - otherContext.getHeight() <= thisPosition.y - thisContext.getHeight())
								| (othersPos.y - otherContext.getHeight() <= thisPosition.y + thisContext.getHeight()))
								// Check bottom side
								| ((othersPos.y + otherContext.getHeight() <= thisPosition.y - thisContext.getHeight())
								| (othersPos.y + otherContext.getHeight() <= thisPosition.y + thisContext.getHeight()))) {
							
							// PERFORM SOME ACTION HERE
							System.out.println("Collision detected!\n");
						}
						
					}
				}
			}
			
		});
	}

}
