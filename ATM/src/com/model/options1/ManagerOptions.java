package com.model.options1;

public enum ManagerOptions {

	CHECKTOTALBALANCE(1), CHECKTOTALWITHDRAWL(2), SEEALLTRANSACTIONS(3), SEEMYTRANSACTIONS(4), CANCEL(5);

	int value;
	ManagerOptions(int val) {
		this.value = val;
	}

	public int getValue() {
		return value;
	}

	static public ManagerOptions getOption(int val) {
		for (ManagerOptions o : ManagerOptions.values()) {
			if (o.getValue() == val)
				return o;
		}
		return null;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
