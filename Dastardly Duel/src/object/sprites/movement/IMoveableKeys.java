package object.sprites.movement;

public interface IMoveableKeys {

	String getLeftKey();
	
	String getRightKey();
	
	String getUpKey();
	
	String getDownKey();
	
	public final IMoveableKeys STANDARD_KEYS = new IMoveableKeys() {

		@Override
		public String getLeftKey() {
			return "LEFT";
		}

		@Override
		public String getRightKey() {
			return "RIGHT";
		}

		@Override
		public String getUpKey() {
			return "UP";
		}

		@Override
		public String getDownKey() {
			return "DOWN";
		}
		
	};
}
