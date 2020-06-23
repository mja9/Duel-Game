package object.gameobjects.update;

import object.gameobjects.AGameObject;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState(AGameObject context, IDispatcher<ICommand> dispatcher);
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState(AGameObject context, IDispatcher<ICommand> dispatcher) {
		}
		
	};

}
