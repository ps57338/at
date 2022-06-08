package com.model.options1;

public enum Currency {

	THOUSAND(1000),HUNDREAD(100),FIFTY(50), TEN(10);	
	int value;
	
	Currency(int val) {
		this.value=val;
	}

	public int getValue() {
		return value;
	}

	
}

