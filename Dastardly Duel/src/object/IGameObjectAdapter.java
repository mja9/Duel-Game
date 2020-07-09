package object;

import java.awt.Component;
import java.awt.Dimension;

import util.dispatcher.ICommand;
import util.dispatcher.IObserver;

public interface IGameObjectAdapter {
	
	public void addObserver(IObserver<ICommand> observer);
	
	public void removeObserver(IObserver<ICommand> observer);

	public Dimension getScreenSize();
	
	public Component getCanvas();
	
	public final IGameObjectAdapter NULL_ADAPTER = new IGameObjectAdapter() {

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

		@Override
		public void removeObserver(IObserver<ICommand> observer) {			
		}
		
	};

}
