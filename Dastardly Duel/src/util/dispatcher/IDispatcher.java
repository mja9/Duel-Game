package util.dispatcher;

public interface IDispatcher<TMessage> {
	
	public Boolean addObserver();
	
	public Boolean addAllObservers();
		
	public Iterable getObservers();

	public IObserver<TMessage> removeObserver(IObserver<TMessage> observer);
	
	public void removeAllObservers();
	
	public void sendMessage(IDispatcher<TMessage> disp, TMessage message);
}
