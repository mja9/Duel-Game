package object.sprites.impl.interactive;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.AObject;
import object.sprites.IGameObject2ControlAdapter;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public abstract class AInteractiveObject extends AObject {
	
//	private final String ID = "interactive";
	
	IUpdateStrategy _updateStrategy = IUpdateStrategy.NULL_UPDATE;

	public AInteractiveObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control);
		_updateStrategy = updateStrategy;
		_updateStrategy.init();
	}

	@Override
	protected void updateState(AObject context, IDispatcher<ICommand> dispatcher) {
		move();
		_updateStrategy.updateState(context, dispatcher);
	}

//	@Override
//	public String getID() {
//		return ID;
//	}
	
	public abstract void move();

}
