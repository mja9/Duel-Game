package model.sprites.movement;

public interface IMovementStrategy {
	
	void init();
	
	void move();
	
	IMovementStrategy NULL_MOVEMENT = new IMovementStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void move() {			
		}
		
	};

}
