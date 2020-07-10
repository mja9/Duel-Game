package object.gameobjects.interaction.impl;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.update.impl.Killed;

/**
 * Removes the context holding this strategy from the list of observers held by the associated dispatcher.
 * @author miguelarana
 *
 */
public class Kill implements IInteractionStrategy {
	
	private AInteractiveObject _context;

	@Override
	public void init(AInteractiveObject context) {
		_context = context;
	}

	@Override
	public void interact(String id, Object ... args) {
		_context.setUpdateStrategy(new Killed());
	}

}
