package model.sprites.action;

public interface IActionStrategy {
	
	void init();
	
	void performAction();
	
	IActionStrategy NULL_ACTION = new IActionStrategy() {

		@Override
		public void init() {			
		}

		@Override
		public void performAction() {			
		}
		
	};

}
