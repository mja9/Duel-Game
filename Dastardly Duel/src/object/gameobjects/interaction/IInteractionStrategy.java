package object.gameobjects.interaction;

import object.gameobjects.impl.interactive.AInteractiveObject;

public interface IInteractionStrategy {
	
	public void init(AInteractiveObject context);
	
	public void interact();
	
	public final IInteractionStrategy NULL_INTERACTION = new IInteractionStrategy() {

		@Override
		public void init(AInteractiveObject context) {
		}

		@Override
		public void interact() {
		}
		
	};

}
