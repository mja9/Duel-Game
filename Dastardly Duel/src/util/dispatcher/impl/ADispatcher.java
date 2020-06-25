package util.dispatcher.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;

public abstract class ADispatcher<TMessage> implements IDispatcher<TMessage> {
	
	private final Comparator<IObserver<TMessage>> observerComparator = new Comparator<IObserver<TMessage>>() {

		@Override
		public int compare(IObserver<TMessage> o1, IObserver<TMessage> o2) {
			return o1.equals(o2) ? 0 : 
				o1.hashCode() <= o2.hashCode() ? -1 : 1;
		}
		
	};
		
	// Create the internal set of Observers
	private ConcurrentSkipListSet<IObserver<TMessage>> observers = new ConcurrentSkipListSet<IObserver<TMessage>>(observerComparator);
	
	protected ConcurrentSkipListSet<IObserver<TMessage>> getObserverSet() {
		return observers;
	}
	
	@Override
	public Boolean addObserver(IObserver<TMessage> observer) {
		return observers.add(observer);
	}

	@Override
	public Boolean addAllObservers(Set<IObserver<TMessage>> observers) {
		return this.observers.addAll((Collection<? extends IObserver<TMessage>>) observers);
	}

	@Override
	public Set<IObserver<TMessage>> getObservers() {
		return observers.clone();	// Obtain a shallow copy.
	}

	@Override
	public Boolean removeObserver(IObserver<TMessage> observer) {
		return observers.remove(observer);
	}

	@Override
	public void removeAllObservers() {
		observers.clear();
	}

}
