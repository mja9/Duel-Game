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
					}
					
				}
			}
			
		});
	}

}
