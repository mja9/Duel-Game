package object.sprites.paint;

import java.awt.Graphics;

import object.sprites.ASprite;

public interface IPaintStrategy {
	
	void init(ASprite context);
	
	void paint(Graphics g, ASprite context);
	
	IPaintStrategy NULL_PAINT = new IPaintStrategy() {
		
		@Override
		public void paint(Graphics g, ASprite context) {			
		}

		@Override
		public void init(ASprite context) {			
		}
		
	};

}
