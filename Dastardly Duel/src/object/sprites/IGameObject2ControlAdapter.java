package object.sprites;

import java.awt.Component;
import java.awt.Dimension;

import util.dispatcher.ICommand;
import util.dispatcher.IObserver;

public interface IGameObject2ControlAdapter {
	
	public void addObserver(IObserver<ICommand> observer);

	public Dimension getScreenSize();
	
	public Component getCanvas();
	
	public final IGameObject2ControlAdapter NULL_ADAPTER = new IGameObject2ControlAdapter() {

		@Override
		public void addObserver(IObserver<ICommand> observer) {			
		}

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
