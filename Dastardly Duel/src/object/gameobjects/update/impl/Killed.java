package object.gameobjects.update.impl;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Killed implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		dispatcher.removeObserver(context);
	}

}
