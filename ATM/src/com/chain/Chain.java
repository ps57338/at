package com.chain;

import com.service.ATM2;

public abstract class Chain {

	protected ATM2 atm;
	
	public abstract void dispense(int money);
	
	public Chain() {
		atm = ATM2.getATM();
	}
	int getATMBalance() {
		return atm.getBalance();
	}
}
