package object.gameobjects.update.impl;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class AOEDetection implements IUpdateStrategy {

	private int _area = 500;
	
	@Override
	public void init() {		
	}

	@Override
	public void updateState(AInteractiveObject thisContext, IDispatcher<ICommand> dispatcher) {	
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(AGameObject otherContext, IDispatcher<ICommand> dispatcher) {
				if (thisContext != otherContext) {
					if (thisContext.getPosition().distance(otherContext.getPosition()) <= _area) {
							thisContext.interact(otherContext.getID(), otherContext);
					}
				}
			}
			
		});
	}

}
