package object.gameobjects.impl.interactive;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.AGameObject;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public abstract class AInteractiveObject extends AGameObject {
	
//	private final String ID = "interactive";
	
	IUpdateStrategy _updateStrategy = IUpdateStrategy.NULL_UPDATE;

	public AInteractiveObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control);
		_updateStrategy = updateStrategy;
		_updateStrategy.init();
	}

	@Override
	protected void updateState(AGameObject context, IDispatcher<ICommand> dispatcher) {
		move();
		_updateStrategy.updateState(context, dispatcher);
	}

//	@Override
//	public String getID() {
//		return ID;
//	}
	
	public abstract void move();

}
