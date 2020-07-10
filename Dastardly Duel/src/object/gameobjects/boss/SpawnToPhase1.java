package object.gameobjects.boss;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.update.IUpdateStrategy;

public class SpawnToPhase1 implements IInteractionStrategy {

	DemoBoss _demoBoss;
	
	@Override
	public void init(AInteractiveObject context) {
		_demoBoss = (DemoBoss) context;
	}

	@Override
	public void interact(String id, Object... args) {
		_demoBoss.setUpdateStrategy(IUpdateStrategy.NULL_UPDATE);	// Remove the Rise strategy once we have fully risen.
		_demoBoss.changePhases("phase 1");
	}

}
