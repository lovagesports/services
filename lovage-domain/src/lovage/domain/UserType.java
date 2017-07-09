package lovage.domain;

/**
 * Defines possible user types.
 */
public enum UserType {

	Player(0), Company(1);

	private final int type;

	UserType(int type) {
		this.type = type;
	}

	/*
	 * Gets the actual value.
	 */
	public int getValue() {
		return type;
	}
}
