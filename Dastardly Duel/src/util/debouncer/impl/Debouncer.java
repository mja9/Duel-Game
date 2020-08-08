package util.debouncer.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import util.debouncer.IDebouncer;

/**
 * An IDebouncer written openly to handle debouncing for any 
 * key triggered on the keyboard concurrently. The timeout for the
 * debounced call is defined by the key triggered to tailot to 
 * variable game cooldowns.
 * 
 * @author miguelarana
 *
 * @param <T> Type of the keys being debounced.
 */
public class Debouncer<T> implements IDebouncer<T> {
	
	private ConcurrentHashMap<T, Runnable> _delayedRemovalMap = new ConcurrentHashMap<T, Runnable>();
	
	public Debouncer() {
	}

	@Override
	public void debouncedCall(T key, Runnable command, int delay) {
		
		if (_delayedRemovalMap.put(key, command) == null) {
			command.run();
			
			ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
			scheduler.schedule(new Runnable() {

				@Override
				public void run() {
					scheduler.shutdown();
					_delayedRemovalMap.remove(key);
				}
				
			}, delay, TimeUnit.MILLISECONDS);
			
		}
		
	}

}
