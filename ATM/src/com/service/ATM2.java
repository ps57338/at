package com.service;


import com.model.customer1.Customer;
import com.model.customer1.Manager;
import com.model.customer1.User;
import com.model.options1.Currency;
import com.states.State;
import com.states.impl.NoCardState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ATM2 implements State {

	private HashMap<Currency, Integer> cashInventory = new HashMap<Currency, Integer>();
	private HashSet<User> cusData = new HashSet<User>();
	private HashSet<Manager> managerData = new HashSet<Manager>();
	private State state;
	private Customer customer;
	private int balance=0;
	private int totalWithdraw=0;

	static final ATM2 atm=new ATM2();
	
	private ATM2() {
		init();
		balance=calculateTotalAvailableNotes(); 	
		// System.out.println("balance " + balance);
		state = new NoCardState(this);
		System.out.println("*****ATM2 machine started*****");
	}
	
	private void init() {
		int noOfNotesForEachDenom = 15; // or user eneterd
		for(Currency cur: Currency.values()) {
			cashInventory.put(cur, noOfNotesForEachDenom);
		}
	}
	
	public static ATM2 getATM() {
		return atm;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	public int getTotalWithdraw() {
		return totalWithdraw;
	}

	public void setTotalWithdraw(int totalWithdraw) {
		this.totalWithdraw = totalWithdraw;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public void displayOptions() {
		this.state.displayOptions();

	}

	@Override
	public void ejectDebitCard() {
		// TODO Auto-generated method stub
		this.state.ejectDebitCard();

	}

	@Override
	public void insertDebitCard() {
		this.state.insertDebitCard();
	}

	public boolean validateCustomer(int number, int PIN) {
		for (User c : cusData) {
			if (c.getCardNumber() == number && c.getPIN() == PIN) {
				setCustomer(c);
				return true;
			}
		}
		for (Manager c : managerData) {
			if (c.getCardNumber() == number && c.getPIN() == PIN) {
				setCustomer(c);
				return true;
			}
		}
		return false;
	}

	public void addCustomerToDB(Customer customer) {
		User u = (User) customer;
		cusData.add(u);
	}

	public void addManagerToDB(Customer manager) {
		Manager m = (Manager) manager;
		managerData.add(m);
	}
	
	public int getAvailableDenominationCount(Currency cur) {
		return cashInventory.get(cur);				
	}
	
	public void deuctCurrency(Currency cur, int numberofnotes) {
		cashInventory.put(cur, cashInventory.get(cur)-numberofnotes);		
	}
	
	int calculateTotalAvailableNotes() {
		int totalAvailable = 0;
		for(Map.Entry<Currency, Integer> c : cashInventory.entrySet()) {
			System.out.println("Available notes " + c.getValue() + " of rs " +  c.getKey().getValue());
			totalAvailable+= (c.getValue() * c.getKey().getValue());
		}
		return totalAvailable;
	}

}
