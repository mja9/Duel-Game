package object.sprites.impl.independent;

import java.awt.Point;

import object.IObject2ModelAdapter;
import object.sprites.AObject;
import object.sprites.paint.IPaintStrategy;

public class IndependentObject extends AObject {
	
	private final String ID = "independent";

	public IndependentObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IObject2ModelAdapter object2Model) {
		super(pos, width, height, paintStrategy, object2Model);
	}

	@Override
	protected void updateState() {		
	}

	@Override
	public String getID() {
		return ID;
	}

}
