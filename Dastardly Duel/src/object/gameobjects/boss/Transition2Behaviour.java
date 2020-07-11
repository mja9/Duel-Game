package object.gameobjects.boss;

import java.awt.Point;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Transition2Behaviour implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		if (context.getPosition().x >= context.getAdapter().getScreenSize().width - 25) {
			context.setSpeed(new Point(0, 0));
			context.interact(context.getID());
		}
	}

}
