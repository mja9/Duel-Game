package object.gameobjects.update.impl;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class DetectBoundary implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		
		// Screen size on the device running the game
		int screenHeight = context.getScreenSize().height;
		int screenWidth = context.getScreenSize().width;
		
		// Check if hitting walls
		if (context.getPosition().x - (context.getWidth() / 2) <= 0) {	// Left wall
			context.interact("left boundary");
		}
		
		if (context.getPosition().x + (context.getWidth() / 2) >= screenWidth) {	// Right wall
			context.interact("right boundary");
		}
		
		// Check if hitting ceiling
		if (context.getPosition().y - (context.getHeight() / 2) <= 0) {
			context.interact("top boundary");
		}
		
		// Check if hitting floor
		if (context.getPosition().y + (context.getHeight() / 2) >= screenHeight - (screenHeight / 4)) {
			context.interact("bottom boundary");
		}

	}

}
