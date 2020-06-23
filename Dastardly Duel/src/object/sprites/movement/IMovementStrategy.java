package object.sprites.movement;

import object.sprites.AObject;

public interface IMovementStrategy {
	
	void init(AObject context);
	
	void move();
	
	IMovementStrategy NULL_MOVEMENT = new IMovementStrategy() {

		@Override
		public void init(AObject context) {			
		}

		@Override
		public void move() {			
		}
		
	};

}
