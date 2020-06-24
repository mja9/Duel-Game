package object.gameobjects.update;

import object.gameobjects.impl.interactive.AInteractiveObject;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher);
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
		}
		
	};

}
