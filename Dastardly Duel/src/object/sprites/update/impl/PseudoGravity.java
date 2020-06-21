package object.sprites.update.impl;

import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class PseudoGravity implements IUpdateStrategy {

	private int _acceleration = 1;
	
	@Override
	public void init() {
		
	}

	@Override
	public void updateState(ASprite context, IDispatcher<ICommand> dispatcher) {
		context.setSpeed(new Point(context.getSpeed().x, 
				context.getSpeed().y < 20 ? context.getSpeed().y + _acceleration : context.getSpeed().y));
	}

}
