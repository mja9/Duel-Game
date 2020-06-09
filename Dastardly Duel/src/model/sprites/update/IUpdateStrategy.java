package model.sprites.update;

public interface IUpdateStrategy {
	
	void init();
	
	void updateState();
	
	IUpdateStrategy NULL_UPDATE = new IUpdateStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void updateState() {
		}
		
	};

}
