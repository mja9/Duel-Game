package model.sprites.paint;

import java.awt.Graphics;
import java.awt.Point;

import model.sprites.ASprite;

public interface IPaintStrategy {
	
	void init(ASprite context);
	
	void paint(Graphics g, ASprite context);
	
	IPaintStrategy NULL_PAINT = new IPaintStrategy() {

		@Override
		public void init(ASprite context) {			
		}

		@Override
		public void paint(Graphics g, ASprite context) {			
		}
		
	};

}
