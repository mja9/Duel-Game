package object.gameobjects.action;

import object.gameobjects.AGameObject;

public interface IActionStrategy {
	
	void init(AGameObject context);
	
	void performAction();
	
	IActionStrategy NULL_ACTION = new IActionStrategy() {

		@Override
		public void init(AGameObject context) {			
		}

		@Override
		public void performAction() {			
		}
		
	};

}
