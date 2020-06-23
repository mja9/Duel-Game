package object.sprites.update;

import object.sprites.AObject;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState(AObject context, IDispatcher<ICommand> dispatcher);
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState(AObject context, IDispatcher<ICommand> dispatcher) {
		}
		
	};

}
