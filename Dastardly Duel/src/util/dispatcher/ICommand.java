package util.dispatcher;

import object.sprites.AObject;

public interface ICommand {
	
	public void apply(AObject context, IDispatcher<ICommand> dispatcher);

}
