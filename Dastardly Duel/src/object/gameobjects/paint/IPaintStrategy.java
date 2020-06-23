package object.gameobjects.paint;

import java.awt.Graphics;

import object.gameobjects.AGameObject;

public interface IPaintStrategy {
	
	void init(AGameObject context);
	
	void paint(Graphics g, AGameObject context);
	
	IPaintStrategy NULL_PAINT = new IPaintStrategy() {
		
		@Override
		public void paint(Graphics g, AGameObject context) {			
		}

		@Override
		public void init(AGameObject context) {			
		}
		
	};

}
