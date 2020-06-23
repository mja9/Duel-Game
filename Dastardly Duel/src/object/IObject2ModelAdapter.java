package object;

import util.dispatcher.ICommand;
import util.dispatcher.IObserver;

public interface IObject2ModelAdapter {
	
	public void addObserver(IObserver<ICommand> observer);
	
	public final IObject2ModelAdapter NULL_ADAPTER = new IObject2ModelAdapter() {

		@Override
		public void addObserver(IObserver<ICommand> observer) {
		}
		
	};

}
