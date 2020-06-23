package object.gameobjects.movement;

import object.gameobjects.AGameObject;

public interface IMovementStrategy {
	
	void init(AGameObject context);
	
	void move();
	
	IMovementStrategy NULL_MOVEMENT = new IMovementStrategy() {

		@Override
		public void init(AGameObject context) {			
		}

		@Override
		public void move() {			
		}
		
	};

}
