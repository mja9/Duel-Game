package object.gameobjects.update.impl;

import object.gameobjects.AGameObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class MultiUpdate implements IUpdateStrategy {

	IUpdateStrategy _strategy1;
	
	IUpdateStrategy _strategy2;
	
	public MultiUpdate(IUpdateStrategy strat1, IUpdateStrategy strat2) {
		_strategy1 = strat1;
		_strategy2 = strat2;
	}
	
	@Override
	public void init() {		
	}

	@Override
	public void updateState(AGameObject context, IDispatcher<ICommand> dispatcher) {
		_strategy1.updateState(context, dispatcher);
		_strategy2.updateState(context, dispatcher);
	}

}
