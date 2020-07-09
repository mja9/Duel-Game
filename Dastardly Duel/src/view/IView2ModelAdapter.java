package view;

import java.awt.Graphics;

public interface IView2ModelAdapter {
	
	public void update(Graphics g);
	
	public void start();
	
	public final IView2ModelAdapter NULL_ADAPTER = new IView2ModelAdapter() {

		@Override
		public void update(Graphics g) {			
		}

		@Override
		public void start() {			
		}
		
	};

}
