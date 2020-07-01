package object.gameobjects.update.impl;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Rise implements IUpdateStrategy {

	private int direction = 1;
	private int maxHeight = 130;

	@Override
	public void init() {
	}

	@Override
	public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		
		if (direction == 1 && context.getHeight() == maxHeight) {
			direction = -1;
			context.setHeight(context.getHeight() + direction);
			
		} else if (direction == -1 && context.getHeight() <= 0) {
			context.interact();
			
		} else {
			context.setHeight(context.getHeight() + direction);
		}
		
	}
	
}
