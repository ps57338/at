package com.service;

import com.model.customer1.Customer;
import com.states.Printer;

public abstract class Transaction implements Printer {

	public Customer customer;
	protected String tx = "";
	public abstract void perform();

	public Transaction(Customer cus) {
		this.customer = cus;
	}
}
