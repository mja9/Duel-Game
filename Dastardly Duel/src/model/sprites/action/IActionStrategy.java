package model.sprites.action;

import model.sprites.ASprite;

public interface IActionStrategy {
	
	void init(ASprite context);
	
	void performAction();
	
	IActionStrategy NULL_ACTION = new IActionStrategy() {

		@Override
		public void init(ASprite context) {			
		}

		@Override
		public void performAction() {			
		}
		
	};

}
