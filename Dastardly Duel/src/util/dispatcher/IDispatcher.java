package util.dispatcher;

import java.util.Set;

public interface IDispatcher<TMessage> {
	
	public Boolean addObserver(IObserver<TMessage> observer);
	
	public Boolean addAllObservers(Set<IObserver<TMessage>> observers);
		
	public Set<IObserver<TMessage>> getObservers();

	public Boolean removeObserver(IObserver<TMessage> observer);
	
	public void removeAllObservers();
	
	public void sendMessage(IDispatcher<TMessage> disp, TMessage message);
}
