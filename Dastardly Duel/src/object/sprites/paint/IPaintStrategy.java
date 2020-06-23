package object.sprites.paint;

import java.awt.Graphics;

import object.sprites.AObject;

public interface IPaintStrategy {
	
	void init(AObject context);
	
	void paint(Graphics g, AObject context);
	
	IPaintStrategy NULL_PAINT = new IPaintStrategy() {
		
		@Override
		public void paint(Graphics g, AObject context) {			
		}

		@Override
		public void init(AObject context) {			
		}
		
	};

}
