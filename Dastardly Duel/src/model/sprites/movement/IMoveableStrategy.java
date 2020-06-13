package model.sprites.movement;

import java.awt.Point;

public interface IMoveableStrategy {
	
	void init();
	
	Point getPoint();
	
	void moveLeft();
	
	void moveRight();
	
	void moveUp();
	
	void moveDown();
	
	void stop();
	
	public final IMoveableStrategy NULL_MOVEABLE = new IMoveableStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public Point getPoint() {
			return new Point(0, 0);
		}

		@Override
		public void moveLeft() {			
		}

		@Override
		public void moveRight() {			
		}

		@Override
		public void moveUp() {			
		}

		@Override
		public void moveDown() {			
		}

		@Override
		public void stop() {			
		}
		
	};

}
