package object.gameobjects.update.impl;

import java.awt.Point;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Rise implements IUpdateStrategy {

	private int direction = 2;
	private int maxHeight = 130;

	@Override
	public void init() {
	}

	@Override
	public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		
		if (direction == 2 && context.getHeight() >= maxHeight) {
			direction = -2;
			context.setHeight(context.getHeight() + direction);
			context.setPosition(new Point(context.getPosition().x, context.getPosition().y - direction / 2));
			
		} else if (direction == -2 && context.getHeight() <= 0) {
			context.interact();
			
		} else {
			context.setHeight(context.getHeight() + direction);
			context.setPosition(new Point(context.getPosition().x, context.getPosition().y - direction / 2));
		}
		
	}
	
}
