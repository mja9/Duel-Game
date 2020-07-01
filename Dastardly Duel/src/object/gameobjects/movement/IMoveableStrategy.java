package object.gameobjects.movement;

import java.awt.Point;

import object.gameobjects.impl.interactive.vagile.manual.ManualObject;

public interface IMoveableStrategy {
	
	void init(ManualObject context);
	
	Point getPoint();
	
	void moveLeft();
	
	void moveRight();
	
	void moveUp();
	
	void moveDown();
	
	void stop();
	
	void act1();
	
	void act2();
	
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
		public void act1() {			
		}

		@Override
		public void act2() {			
		}
		
	};

}
