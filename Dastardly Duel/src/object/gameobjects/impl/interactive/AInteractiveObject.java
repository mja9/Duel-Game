package object.gameobjects.impl.interactive;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.gameobjects.AGameObject;
import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public abstract class AInteractiveObject extends AGameObject {
	
//	private final String ID = "interactive";
	
	IUpdateStrategy _updateStrategy = IUpdateStrategy.NULL_UPDATE;
	
	IInteractionStrategy _interactStrategy = IInteractionStrategy.NULL_INTERACTION;

	public AInteractiveObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control, IUpdateStrategy updateStrategy, 
			IInteractionStrategy interactStrategy) {
		super(pos, width, height, paintStrategy, gameObject2Control);
		_updateStrategy = updateStrategy;
		_updateStrategy.init();
		_interactStrategy = interactStrategy;
		_interactStrategy.init(this);
	}

	@Override
	protected void updateState(AGameObject context, IDispatcher<ICommand> dispatcher) {
		move();
		_updateStrategy.updateState(this, dispatcher);
	}
	
	public void interact() {
		_interactStrategy.interact();
	}

//	@Override
//	public String getID() {
//		return ID;
//	}
	
	public abstract void move();

}
