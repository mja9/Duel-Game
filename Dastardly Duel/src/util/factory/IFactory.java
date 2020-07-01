package util.factory;

public interface IFactory<Product> {

	public Product make(Object... parameters);
	
}
