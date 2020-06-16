package model;

import java.awt.Component;
import java.awt.Dimension;
import java.util.function.Consumer;

public interface IModel2ViewAdapter {
	
	public void update();
	
	public void addKeyCommand(String key, Consumer<String> command);
	
	public Dimension getScreenSize();
	
	public Component getCanvas();
	
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
		public Component getCanvas() {
			return null;
		}
		
	};

}
