package com.model.options1;

public enum Option {

	WITHDRAWL(1), DEPOSIT(2), CHECKBALANCE(3), CANCEL(4);

	int value;
	
	Option(int val) {
		this.value = val;
	}

	public int getValue() {
		return value;
	}

	static public Option getOption(int val) {

		for (Option o : Option.values()) {
			if (o.getValue() == val)
				return o;
		}
		return null;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
