package model.sprites.paint;

import java.awt.Graphics;
import java.awt.Point;

public interface IPaintStrategy {
	
	void init();
	
	void paint(Graphics g, Point p);
	
	IPaintStrategy NULL_PAINT = new IPaintStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void paint(Graphics g, Point p) {			
		}
		
	};

}
