package model;

import java.util.function.Consumer;

public interface IModel2ViewAdapter {
	
	public void update();
	
	public void addKeyCommand(String key, Consumer<String> command);
	
	IModel2ViewAdapter NULL_ADAPTER = new IModel2ViewAdapter() {

		@Override
		public void update() {			
		}

		@Override
		public void addKeyCommand(String key, Consumer<String> command) {			
		}
		
	};

}
