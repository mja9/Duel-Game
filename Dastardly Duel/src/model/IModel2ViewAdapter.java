package model;

public interface IModel2ViewAdapter {
	
	public void update();
	
	IModel2ViewAdapter NULL_ADAPTER = new IModel2ViewAdapter() {

		@Override
		public void update() {			
		}
		
	};

}
