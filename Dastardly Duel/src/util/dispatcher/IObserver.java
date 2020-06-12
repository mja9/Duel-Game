package util.dispatcher;

public interface IObserver<TMessage> {

	public void recieve(IDispatcher<TMessage> dispatcher, TMessage message);
	
}
