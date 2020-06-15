package model.sprites.update.impl;

import model.sprites.ASprite;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Collision implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(ASprite thisContext, IDispatcher<ICommand> dispatcher) {
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(ASprite nextContext, IDispatcher<ICommand> dispatcher) {
				
			}
			
		});
	}

}
