package object.gameobjects.boss;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.interaction.IInteractionStrategy;

public class ChangeState implements IInteractionStrategy {
	
	DemoBoss _demoBoss;

	@Override
	public void init(AInteractiveObject context) {	
		_demoBoss = (DemoBoss) context;
	}

	@Override
	public void interact(String id, Object... args) {	
		_demoBoss.changePhases();
	}

}
