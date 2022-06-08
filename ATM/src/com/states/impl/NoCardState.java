package com.states.impl;

import com.service.ATM2;
import com.states.State;

public class NoCardState implements State {
	private ATM2 atm;

	public NoCardState(ATM2 atm) {
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
		System.out.println("Cant display. Insert card");

	}

	@Override
	public void ejectDebitCard() {
		System.out.println("cant eject no card insrted");

	}

	@Override
	public void insertDebitCard() {
		System.out.println("card inserted");
		this.atm.setState(new CardState(atm));
	}

}
