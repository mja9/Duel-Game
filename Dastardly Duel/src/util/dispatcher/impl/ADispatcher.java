package util.dispatcher.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;

public abstract class ADispatcher<TMessage> implements IDispatcher<TMessage> {
	
	private HashSet<IObserver<TMessage>> toRemove = new HashSet<IObserver<TMessage>>();
	
	// Create the internal set of Observers
	private HashSet<IObserver<TMessage>> observers = new HashSet<IObserver<TMessage>>();
	
	protected HashSet<IObserver<TMessage>> getObserverSet() {
		return observers;
	}
	
	protected HashSet<IObserver<TMessage>> getRemovalSet() {
		return toRemove;
	}

	@Override
	public Boolean addObserver(IObserver<TMessage> observer) {
		return observers.add(observer);
	}

	@Override
	public Boolean addAllObservers(Set<IObserver<TMessage>> observers) {
		return this.observers.addAll((Collection<? extends IObserver<TMessage>>) observers);
	}

	@SuppressWarnings("unchecked")
	@Override
	// TODO Find a way to safely remove the suppress warning.
	public Set<IObserver<TMessage>> getObservers() {
		return (HashSet<IObserver<TMessage>>) observers.clone();	// Obtain a shallow copy.
	}

	@Override
	public Boolean removeObserver(IObserver<TMessage> observer) {
//		return observers.remove(observer);
		return toRemove.add(observer);
	}

	@Override
	public void removeAllObservers() {
		observers.clear();
	}

}
