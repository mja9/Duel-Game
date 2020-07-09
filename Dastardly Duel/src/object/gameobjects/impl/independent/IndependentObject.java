package object.gameobjects.impl.independent;

import java.awt.Point;

import object.IGameObjectAdapter;
import object.IObject2ViewAdapter;
import object.gameobjects.AGameObject;
import object.gameobjects.paint.IPaintStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class IndependentObject extends AGameObject {
	
	private final String ID = "independent";

	public IndependentObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObjectAdapter gameObject2Control) {
		super(pos, width, height, paintStrategy, gameObject2Control);
	}

	@Override
	protected void updateState(AGameObject context, IDispatcher<ICommand> dispatcher) {		
	}

	@Override
	public String getID() {
		return ID;
	}

}
