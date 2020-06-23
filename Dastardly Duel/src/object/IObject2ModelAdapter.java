package object;

import java.awt.Component;
import java.awt.Dimension;

public interface IObject2ModelAdapter {
	
	public Dimension getScreenSize();
	
	public Component getCanvas();
	
	public final IObject2ModelAdapter NULL_ADAPTER = new IObject2ModelAdapter() {

		@Override
		public Dimension getScreenSize() {
			return null;
		}

		@Override
		public Component getCanvas() {
			return null;
		}
		
	};

}
