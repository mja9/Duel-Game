package model.sprites.update;

import model.sprites.Sprite;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState(Sprite context);
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState(Sprite context) {
		}
		
	};

}
