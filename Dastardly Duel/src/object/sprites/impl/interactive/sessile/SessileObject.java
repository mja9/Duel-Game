package object.sprites.impl.interactive.sessile;

import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.impl.interactive.AInteractiveObject;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;

public class SessileObject extends AInteractiveObject {
	
	private final String ID = "sessile";

	public SessileObject(Point pos, int width, int height, IPaintStrategy paintStrategy,
			IObject2ViewAdapter object2Model, IUpdateStrategy updateStrategy) {
		super(pos, width, height, paintStrategy, object2Model, updateStrategy);
	}

	@Override
	public void move() {		
	}
	
	@Override
	public String getID() {
		return ID;
	}

}
