package model.sprites.movement;

public interface IMoveableKeys {

	String getLeftKey();
	
	String getRightKey();
	
	String getUpKey();
	
	String getDownKey();
	
	public final IMoveableKeys STANDARD_KEYS = new IMoveableKeys() {

		@Override
		public String getLeftKey() {
			return "A";
		}

		@Override
		public String getRightKey() {
			return "D";
		}

		@Override
		public String getUpKey() {
			return "W";
		}

		@Override
		public String getDownKey() {
			return "S";
		}
		
	};
}
