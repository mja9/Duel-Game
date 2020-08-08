package util.debouncer;

public interface IDebouncer<T> {
	
	void debouncedCall(T key, Runnable command, int delay);

}
