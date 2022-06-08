package com.states.impl;

import com.model.customer1.Customer;
import com.model.customer1.Manager;
import com.model.customer1.User;
import com.service.ATM2;
import com.service.Display;
import com.service.impl.ClientDisplay;
import com.service.impl.ManagerDisplay;
import com.states.State;

public class CardState implements State {

	private ATM2 atm;

	CardState(ATM2 atm) {
		this.atm = atm;
	}

	public ATM2 getAtm() {
		return atm;
	}

	public void setAtm(ATM2 atm) {
		this.atm = atm;
	}

	@Override
	public void displayOptions() {
		Customer cus = atm.getCustomer();
		Display display = null;
		if (cus instanceof Manager) {
			display = ManagerDisplay.getDisplay();
		} else if (cus instanceof User) {
			display = ClientDisplay.getDisplay();
		}
		display.setCustomer(cus);
		display.show();
		display.clearTransaction();
		ejectDebitCard();

	}

	@Override
	public void ejectDebitCard() {
		System.out.println("ejecting debit card");
		atm.setState(new NoCardState(atm));

	}

	@Override
	public void insertDebitCard() {
		System.out.println("sorry aleready card inserted");

	}

}
