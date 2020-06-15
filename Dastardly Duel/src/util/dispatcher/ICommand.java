package util.dispatcher;

import model.sprites.ASprite;

public interface ICommand {
	
	public void apply(ASprite context, IDispatcher<ICommand> dispatcher);

}
