package object.sprites.movement;

import java.awt.Point;

import object.sprites.impl.interactive.vagile.manual.ManualObject;

public interface IMoveableStrategy {
	
	void init(ManualObject context);
	
	Point getPoint();
	
	void moveLeft();
	
	void moveRight();
	
	void moveUp();
	
	void moveDown();
	
	void stop();
	
	void act();
	
	public final IMoveableStrategy NULL_MOVEABLE = new IMoveableStrategy() {

		@Override
		public void init(ManualObject context) {			
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

		@Override
		public void act() {			
		}
		
	};

}
