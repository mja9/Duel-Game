package model.sprites.update;

import model.sprites.ASprite;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState(ASprite context, IDispatcher<ICommand> dispatcher);
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState(ASprite context, IDispatcher<ICommand> dispatcher) {
		}
		
	};

}
