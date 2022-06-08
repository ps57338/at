package com.service.impl;

import com.model.customer1.Customer;
import com.service.Transaction;
import com.states.Printer;

public class CheckBalance extends Transaction implements Printer {

	CheckBalance(Customer cus) {
		super(cus);
	}

	@Override
	public void perform() {
		System.out.println(customer.getName() + " checking balance Balance: " + customer.getBalance());
	}

	@Override
	public String print() {
		return customer.getName() + " checking balance Balance: " + customer.getBalance();
	}
}
