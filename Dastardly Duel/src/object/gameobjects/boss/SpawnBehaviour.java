package object.gameobjects.boss;

import java.awt.Point;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class SpawnBehaviour implements IUpdateStrategy {

	private int direction = 2;
	private int maxHeight = 130;
	private int maxWidth = 36;

	@Override
	public void init() {
	}

	@Override
	public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		
		if (direction == 2 && context.getHeight() >= maxHeight) {
			context.interact(context.getID());
			
		} else {
			context.setHeight(context.getHeight() + direction);
			context.setPosition(new Point(context.getPosition().x, context.getPosition().y - direction / 2));
		}
		
		if (context.getWidth() < maxWidth) {
			context.setWidth(context.getWidth() + direction);
		}
		
	}

}
