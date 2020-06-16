package model;

import java.awt.Dimension;
import java.awt.image.ImageObserver;
import java.util.function.Consumer;

public interface IModel2ViewAdapter {
	
	public void update();
	
	public void addKeyCommand(String key, Consumer<String> command);
	
	public Dimension getScreenSize();
	
	public ImageObserver getCanvas();
	
	IModel2ViewAdapter NULL_ADAPTER = new IModel2ViewAdapter() {

		@Override
		public void update() {			
		}

		@Override
		public void addKeyCommand(String key, Consumer<String> command) {			
		}

		@Override
		public Dimension getScreenSize() {
			return new Dimension(0, 0);
		}

		@Override
		public ImageObserver getCanvas() {
			return null;
		}
		
	};

}
