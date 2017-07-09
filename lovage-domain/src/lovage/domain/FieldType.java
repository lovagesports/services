package lovage.domain;

/**
 * Defines possible field types.
 */
public enum FieldType {

	Football(0), Tennis(1), Basketball(2);

	private final int type;

	FieldType(int type) {
		this.type = type;
	}

	/*
	 * Gets the actual value.
	 */
	public int getValue() {
		return type;
	}
}
