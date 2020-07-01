package object.gameobjects.movement;

public interface IMoveableKeys {

	String getLeftKey();
	
	String getRightKey();
	
	String getUpKey();
	
	String getDownKey();
	
	String getPrimaryActionKey();
	
	String getSecondaryActionKey();
	
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

		@Override
		public String getPrimaryActionKey() {
			return "M";
		}

		@Override
		public String getSecondaryActionKey() {
			return "N";
		}
		
	};
}
