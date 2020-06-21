package util.dispatcher;

import object.sprites.ASprite;

public interface ICommand {
	
	public void apply(ASprite context, IDispatcher<ICommand> dispatcher);

}
