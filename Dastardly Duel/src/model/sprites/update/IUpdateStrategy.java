package model.sprites.update;

import model.sprites.ASprite;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState(ASprite context);
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState(ASprite context) {
		}
		
	};

}
