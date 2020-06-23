package object.sprites.action;

import object.sprites.AObject;

public interface IActionStrategy {
	
	void init(AObject context);
	
	void performAction();
	
	IActionStrategy NULL_ACTION = new IActionStrategy() {

		@Override
		public void init(AObject context) {			
		}

		@Override
		public void performAction() {			
		}
		
	};

}
