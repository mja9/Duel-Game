package util.dispatcher;

import object.gameobjects.AGameObject;

public interface ICommand {
	
	public void apply(AGameObject context, IDispatcher<ICommand> dispatcher);

}
