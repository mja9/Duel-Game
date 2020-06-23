package object.sprites.impl.independent;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.AObject;
import object.sprites.IGameObject2ControlAdapter;
import object.sprites.paint.IPaintStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class IndependentObject extends AObject {
	
	private final String ID = "independent";

	public IndependentObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IGameObject2ControlAdapter gameObject2Control) {
		super(pos, width, height, paintStrategy, gameObject2Control);
	}

	@Override
	protected void updateState(AObject context, IDispatcher<ICommand> dispatcher) {		
	}

	@Override
	public String getID() {
		return ID;
	}

}
