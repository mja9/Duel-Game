package model.sprites.movement;

import model.sprites.ASprite;

public interface IMovementStrategy {
	
	void init(ASprite context);
	
	void move();
	
	IMovementStrategy NULL_MOVEMENT = new IMovementStrategy() {

		@Override
		public void init(ASprite context) {			
		}

		@Override
		public void move() {			
		}
		
	};

}
