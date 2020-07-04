package model;

public interface IModel2ObjectAdapter {
	
	void updateRemotePlayer(String id);
	
	public final IModel2ObjectAdapter NULL_ADAPTER = new IModel2ObjectAdapter() {

		@Override
		public void updateRemotePlayer(String id) {
		}
		
	};

}
