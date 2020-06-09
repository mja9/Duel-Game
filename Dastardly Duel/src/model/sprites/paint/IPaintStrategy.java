package model.sprites.paint;

public interface IPaintStrategy {
	
	void init();
	
	void paint();
	
	IPaintStrategy NULL_PAINT = new IPaintStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void paint() {			
		}
		
	};

}
