package object.gameobjects.impl.interactive;

import java.awt.Point;

import object.IGameObjectAdapter;
import object.IObject2ViewAdapter;
import object.gameobjects.AGameObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public abstract class AInteractiveObject extends AGameObject {
		
	IUpdateStrategy _updateStrategy = IUpdateStrategy.NULL_UPDATE;
	
	IInteractionStrategy _interactStrategy = IInteractionStrategy.NULL_INTERACTION;

	public AInteractiveObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control, IUpdateStrategy updateStrategy, 
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
	
	public void setUpdateStrategy(IUpdateStrategy newStrat) {
		_updateStrategy = newStrat;
		_updateStrategy.init();
	}
		
	public void interact(String id, Object ... args) {
		_interactStrategy.interact(id, args);
	}
	
	public void setInteractionStrategy(IInteractionStrategy newStrat) {
		_interactStrategy = newStrat;
		_interactStrategy.init(this);
	}
	
	public abstract void move();

}
