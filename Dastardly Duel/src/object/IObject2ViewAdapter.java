package object;

import java.awt.Component;
import java.awt.Dimension;
import java.util.function.Consumer;

public interface IObject2ViewAdapter {
	
	public Dimension getScreenSize();
	
	public Component getCanvas();
	
	public void addKeyCommand(String key, Consumer<String> command);
	
	public final IObject2ViewAdapter NULL_ADAPTER = new IObject2ViewAdapter() {

		@Override
		public Dimension getScreenSize() {
			return null;
		}

		@Override
		public Component getCanvas() {
			return null;
		}

		@Override
		public void addKeyCommand(String key, Consumer<String> command) {			
		}
		
	};

}
