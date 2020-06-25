package util.dispatcher.impl;

public class StandardDispatcher<TMessage> extends ADispatcher<TMessage> {

	@Override
	public void sendMessage(TMessage message) {
		this.getObserverSet().forEach((obs) -> obs.recieve(this, message));
		this.getObserverSet().removeAll(this.getRemovalSet());
	}

}
